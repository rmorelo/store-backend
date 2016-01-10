package br.com.store.backend.application.pet;

import java.util.Collection;

import br.com.store.backend.view.resource.pet.Breed;

public interface BreedApplication {
    
    Breed findBreed(Integer idBreed);
    
    Collection<Breed> findBreedByAnimal(Integer idAnimal, String selector);
    
    Collection<Breed> findBreeds();
    
    Breed saveBreed(Breed breed);
    
    Breed update(Breed breed);
        
    void delete(Integer idBreed);
    
}
