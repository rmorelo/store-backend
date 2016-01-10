package br.com.store.backend.domain.service.pet;

import java.util.Collection;
import br.com.store.backend.view.resource.pet.Animal;

public interface AnimalService {
  
    Animal findAnimal(Integer idAnimal);
    
    Collection<Animal> findAnimalsByCustomer(Integer idCustomer);
    
    Animal saveAnimalOfCustomer(Animal animal, Integer idCustomer);
    
    Animal update(Animal animal);
    
    Animal updateBreedOfAnimal(Integer idAnimal, Integer idBreed);
    
    void delete(Integer idAnimal);
}
