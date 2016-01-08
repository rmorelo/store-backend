package br.com.store.backend.domain.service.pet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.store.backend.view.resource.pet.Animal;

public interface AnimalService {
  
    Animal findAnimal(Integer idAnimal);
    
    Page<Animal> findAnimalsByCustomer(Integer idCustomer, Pageable pageable);
    
    Animal saveAnimalOfCustomer(Animal animal, Integer idCustomer);
    
    Animal update(Animal animal);
    
    Animal updateBreedOfAnimal(Integer idAnimal, Integer idBreed);
    
    void delete(Integer idAnimal);
}
