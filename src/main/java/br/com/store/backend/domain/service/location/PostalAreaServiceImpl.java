package br.com.store.backend.domain.service.location;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.PostalAreaEntity;
import br.com.store.backend.domain.repository.partner.PostalAreaRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.PostalArea;

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
        
        return PostalAreaConverter.convert(postalAreaEntity);
    }

}
