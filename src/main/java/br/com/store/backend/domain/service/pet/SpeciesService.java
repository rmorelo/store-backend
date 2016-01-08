package br.com.store.backend.domain.service.pet;

import br.com.store.backend.view.resource.pet.Group;
import br.com.store.backend.view.resource.pet.Species;

public interface SpeciesService {
	
    Species findSpecies(Integer idSpecies);
    
    Group findGroupBySpecies(Integer idSpecies);
  
}
