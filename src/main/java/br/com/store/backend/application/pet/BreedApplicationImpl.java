package br.com.store.backend.application.pet;

import java.util.Collection;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.service.pet.BreedService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.pet.Breed;

@Service
@Transactional(readOnly = true)
public class BreedApplicationImpl implements BreedApplication {

    @Autowired
    private BreedService breedService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Breed findBreed(Integer idBreed) {
    	return breedService.findBreed(idBreed);
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Collection<Breed> findBreeds() {
    	return breedService.findBreeds();
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Breed saveBreed(Breed breed) {
        return breedService.saveBreed(breed);
    }
    
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public Breed update(Breed breed) {
        return breedService.update(breed);
    }
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public void delete(Integer idBreed) {
        breedService.delete(idBreed);
    }
		
}
