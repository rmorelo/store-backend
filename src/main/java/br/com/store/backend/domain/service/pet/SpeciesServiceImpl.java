package br.com.store.backend.domain.service.pet;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.entity.pet.GroupEntity;
import br.com.store.backend.domain.entity.pet.SpeciesEntity;
import br.com.store.backend.domain.repository.pet.SpeciesRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.pet.Group;
import br.com.store.backend.view.resource.pet.Species;

@Service
@Transactional(readOnly = true)
public class SpeciesServiceImpl implements SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Species findSpecies(Integer idSpecies) {
        SpeciesEntity speciesEntity = speciesRepository.findOne(idSpecies);
                
        if(speciesEntity == null){
            throw new NotFoundException(NotFoundException.SPECIES_NOT_FOUND);
        }
        
        return SpeciesConverter.convert(speciesEntity);
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Group findGroupBySpecies(Integer idSpecies) {
        SpeciesEntity speciesEntity = speciesRepository.findOne(idSpecies);
        
        if(speciesEntity == null){
            throw new NotFoundException(NotFoundException.SPECIES_NOT_FOUND);
        }
        
        GroupEntity groupEntity = speciesEntity.getGroup();
        
        if(groupEntity == null){
            throw new NotFoundException(NotFoundException.GROUP_NOT_FOUND);
        }
        
        return GroupConverter.convert(groupEntity);
    }

}
