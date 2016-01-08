package br.com.store.backend.application.pet;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.pet.BreedService;
import br.com.store.backend.domain.service.pet.SpeciesService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.location.Country;
import br.com.store.backend.view.resource.pet.Group;
import br.com.store.backend.view.resource.pet.Species;

@Service
public class SpeciesApplicationImpl implements SpeciesApplication {
    
	@Autowired
	private BreedService breedService;
	
	@Autowired
    private SpeciesService speciesService;
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public Species findSpeciesByBreed(Integer idBreed, String selector){
	    Species species = breedService.findSpeciesByBreed(idBreed);
	    addGroup(species, selector);
        return species;
    }
	
    @Override
    @Profiled(level = Profiling.APPLICATION)
	public Species findSpecies(Integer idSpecies, String selector){
        Species species = speciesService.findSpecies(idSpecies);
        addGroup(species, selector);
		return species;
	}
    
    private void addGroup(Species species, String selector) {
    	if (selector != null && selector.equals(Species.GROUPS)){
    		Group group = speciesService.findGroupBySpecies(species.getIdSpecies());
    	    species.setGroup(group);
    	}
    }
}