package br.com.store.backend.domain.service.location;

import java.util.ArrayList;
import java.util.Collection;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.location.DistrictEntity;
import br.com.store.backend.domain.entity.location.PostalAreaEntity;
import br.com.store.backend.domain.repository.location.PostalAreaRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.location.District;
import br.com.store.backend.view.resource.location.PostalArea;

@Service
@Transactional(readOnly = true)
public class PostalAreaServiceImpl implements PostalAreaService {

    @Autowired
    private PostalAreaRepository postalAreaRepository;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public PostalArea findByCodPostalArea(String codPostalArea) {
        PostalAreaEntity postalAreaEntity = postalAreaRepository.findByCodPostalArea(codPostalArea);
                
        if(postalAreaEntity == null){
            throw new NotFoundException(NotFoundException.POSTAL_AREA_NOT_FOUND);
        }
        
        PostalArea postalArea = PostalAreaConverter.convert(postalAreaEntity);
        
        return postalArea;
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Collection<District> findDistrictsByPostalArea(Integer idPostalArea){
    	PostalAreaEntity postalAreaEntity = postalAreaRepository.findOne(idPostalArea);
    	
    	if(postalAreaEntity == null){
            throw new NotFoundException(NotFoundException.POSTAL_AREA_NOT_FOUND);
        }

    	Collection<District> districts = new ArrayList<District>();
    	Collection<DistrictEntity> districtEntities = postalAreaEntity.getDistricts();
    	
    	for (DistrictEntity districtEntity : districtEntities){
    		District district = DistrictConverter.convert(districtEntity);
    		districts.add(district);
    	}
    	
    	return districts;
    }

}
