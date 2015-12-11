package br.com.store.backend.domain.service.location;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.CityEntity;
import br.com.store.backend.domain.repository.partner.CityRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.City;

@Service
@Transactional(readOnly = true)
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public City find(Integer idCity) {
        CityEntity cityEntity = cityRepository.findOne(idCity);
                
        if(cityEntity == null){
            throw new NotFoundException(NotFoundException.CITY_NOT_FOUND);
        }
        
        return CityConverter.convert(cityEntity);
    }

}
