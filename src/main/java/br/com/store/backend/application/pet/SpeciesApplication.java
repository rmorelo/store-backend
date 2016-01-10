package br.com.store.backend.application.pet;

import br.com.store.backend.view.resource.pet.Species;

public interface SpeciesApplication {
 	
    Species findSpeciesByBreed(Integer idBreed, String selector);
    
    Species findSpecies(Integer idSpecies, String selector);
	
}
