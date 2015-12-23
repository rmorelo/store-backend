package br.com.store.backend.domain.service.location;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.location.CityEntity;
import br.com.store.backend.domain.entity.location.FederationUnitEntity;
import br.com.store.backend.domain.repository.location.CityRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.location.City;
import br.com.store.backend.view.resource.location.FederationUnit;

@Service
@Transactional(readOnly = true)
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public City findCity(Integer idCity) {
        CityEntity cityEntity = cityRepository.findOne(idCity);
                
        if(cityEntity == null){
            throw new NotFoundException(NotFoundException.CITY_NOT_FOUND);
        }
        
        return CityConverter.convert(cityEntity);
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public FederationUnit findFederationUnitByCity(Integer idCity) {
        CityEntity cityEntity = cityRepository.findOne(idCity);
                
        if(cityEntity == null){
            throw new NotFoundException(NotFoundException.CITY_NOT_FOUND);
        }
        
        FederationUnitEntity federationUnitEntity = cityEntity.getFederationUnit();
        
        if(federationUnitEntity == null){
            throw new NotFoundException(NotFoundException.FEDERATION_UNIT_NOT_FOUND);
        }
        
        return FederationUnitConverter.convert(federationUnitEntity);
    }

}
