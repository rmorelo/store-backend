package br.com.store.backend.domain.service.pet;

import java.util.Collection;
import br.com.store.backend.view.resource.pet.Breed;

public interface BreedService {
  
    Breed findBreed(Integer idBreed);
    
    Collection<Breed> findBreeds();
    
    Breed saveBreed(Breed breed);
    
    Breed update(Breed breed);
    
    void delete(Integer idBreed);
}
