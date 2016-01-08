package br.com.store.backend.domain.service.pet;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Resource;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.entity.pet.BreedEntity;
import br.com.store.backend.domain.repository.pet.BreedRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.pet.Breed;

@Service
@Transactional(readOnly = true)
public class BreedServiceImpl implements BreedService {

    @Autowired
    private BreedRepository breedRepository;
    
    @Resource
	private BreedServiceMapper breedServiceMapper;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Breed findBreed(Integer idBreed) {
        BreedEntity breedEntity = breedRepository.findOne(idBreed);
    	
    	if(breedEntity == null){
    		throw new NotFoundException(NotFoundException.BREED_NOT_FOUND);
    	}
    	
    	return BreedConverter.convert(breedEntity);
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Collection<Breed> findBreeds() {
    	Collection<BreedEntity> breedEntities = breedRepository.findAll();
    	
    	if(breedEntities == null || breedEntities.isEmpty()){
    		throw new NotFoundException(NotFoundException.BREED_NOT_FOUND);
    	}
        
        Collection<Breed> breeds = new ArrayList<Breed>();

        for (BreedEntity breedEntity : breedEntities){
            Breed breed = BreedConverter.convert(breedEntity);
            breeds.add(breed);
        }
        
        return breeds;
    }
    
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Breed saveBreed(Breed breed) {
    	BreedEntity breedEntity = BreedConverter.convert(breed);       
    	breedEntity = breedRepository.save(breedEntity);
        return BreedConverter.convert(breedEntity);
	}
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public Breed update(Breed breed) {    	
    	BreedEntity breedEntity = breedRepository.findOne(breed.getIdBreed());
    	
    	if(breedEntity == null){
    		throw new NotFoundException(NotFoundException.BREED_NOT_FOUND);
    	}
    	
    	breedServiceMapper.mapBreedToBreedEntity(breed, breedEntity);
    	BreedEntity breedEntitySaved = breedRepository.save(breedEntity);
        return BreedConverter.convert(breedEntitySaved);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public void delete(Integer idBreed) {
    	BreedEntity breedEntity = breedRepository.findOne(idBreed);
    	
    	if(breedEntity == null){
    		throw new NotFoundException(NotFoundException.BREED_NOT_FOUND);
    	}
    	
        breedRepository.delete(breedEntity.getIdBreed());        
    }
    
}
