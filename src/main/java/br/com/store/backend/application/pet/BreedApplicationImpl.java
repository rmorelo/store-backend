package br.com.store.backend.application.pet;

import java.util.Collection;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.service.pet.BreedService;
import br.com.store.backend.domain.service.pet.SpeciesService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.pet.Breed;
import br.com.store.backend.view.resource.pet.Species;

@Service
@Transactional(readOnly = true)
public class BreedApplicationImpl implements BreedApplication {

    @Autowired
    private BreedService breedService;
    
    @Autowired
    private SpeciesService speciesService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Breed findBreed(Integer idBreed, String selector) {
    	Breed breed = breedService.findBreed(idBreed);
    	addSelector(breed, selector);
    	return breed;
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Collection<Breed> findBreeds() {
    	return breedService.findBreeds();
    }

    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Collection<Breed> findBreedByAnimal(Integer idAnimal, String selector){
    	return breedService.findBreedByAnimal(idAnimal);
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
	
	private void addSelector(Breed breed, String selector) {
        if(selector != null && selector.equals(Breed.SPECIES)){
			addSpecies(breed);
		}       
    }
	
	private void addSpecies(Breed breed) {
		Species species = speciesService.findSpeciesByBreed(breed.getIdBreed());
		breed.setSpecies(species);
	}
		
}
