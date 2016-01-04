package br.com.store.backend.domain.service.location;

import java.util.ArrayList;
import java.util.Collection;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.location.CityEntity;
import br.com.store.backend.domain.entity.location.DistrictEntity;
import br.com.store.backend.domain.entity.location.PostalAreaEntity;
import br.com.store.backend.domain.repository.location.DistrictRepository;
import br.com.store.backend.domain.repository.location.PostalAreaRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.location.City;
import br.com.store.backend.view.resource.location.District;

@Service
@Transactional(readOnly = true)
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;
    
    @Autowired
    private PostalAreaRepository postalAreaRepository;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public City findCityByDistrict(Integer idDistrict) {
        DistrictEntity districtEntity = districtRepository.findOne(idDistrict);
                
        if(districtEntity == null){
            throw new NotFoundException(NotFoundException.DISTRICT_NOT_FOUND);
        }

        CityEntity cityEntity = districtEntity.getCity();
        
        if(cityEntity == null){
            throw new NotFoundException(NotFoundException.CITY_NOT_FOUND);
        }
        
        return CityConverter.convert(cityEntity);
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public District findDistrict(Integer idDistrict) {
        DistrictEntity districtEntity = districtRepository.findOne(idDistrict);
                
        if(districtEntity == null){
            throw new NotFoundException(NotFoundException.DISTRICT_NOT_FOUND);
        }
        
        return DistrictConverter.convert(districtEntity);
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Collection<District> findDistrictsByPostalArea(Integer idPostalArea){
        PostalAreaEntity postalAreaEntity = postalAreaRepository.findOne(idPostalArea);
        
        if(postalAreaEntity == null){
            throw new NotFoundException(NotFoundException.POSTAL_AREA_NOT_FOUND);
        }

        Collection<District> districts = new ArrayList<District>();
        Collection<DistrictEntity> districtEntities = districtRepository.findAllByPostalArea(postalAreaEntity);
        
        for (DistrictEntity districtEntity : districtEntities){
            District district = DistrictConverter.convert(districtEntity);
            districts.add(district);
        }
        
        return districts;
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Collection<District> findDistrictsByPostalArea(String codPostalArea){
        PostalAreaEntity postalAreaEntity = postalAreaRepository.findByCodPostalArea(codPostalArea);
            
        if(postalAreaEntity == null){
            throw new NotFoundException(NotFoundException.POSTAL_AREA_NOT_FOUND);
        }

        Collection<District> districts = new ArrayList<District>();
        Collection<DistrictEntity> districtEntities = districtRepository.findAllByPostalArea(postalAreaEntity);
            
        for (DistrictEntity districtEntity : districtEntities){
            District district = DistrictConverter.convert(districtEntity);
            districts.add(district);
        }
        
        return districts;
    }

}