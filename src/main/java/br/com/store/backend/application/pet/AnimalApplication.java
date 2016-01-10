package br.com.store.backend.application.pet;

import java.util.Collection;
import br.com.store.backend.view.resource.pet.Animal;

public interface AnimalApplication {
    
    Animal findAnimal(Integer idAnimal, String[] selectors);
    
    Collection<Animal> findAnimalsByIdCustomer(Integer idCustomer);
    
    Animal saveAnimalOfCustomer(Animal animal, Integer idCustomer);
    
    Animal update(Animal animal);
    
    Animal updateBreedOfAnimal(Integer idAnimal, Integer idBreed);
        
    void delete(Integer idAnimal);
    
}
