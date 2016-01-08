package br.com.store.backend.application.pet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.store.backend.view.resource.pet.Animal;

public interface AnimalApplication {
    
    Animal findAnimal(Integer idAnimal, String[] selectors);
    
    Page<Animal> findAnimalsByIdCustomer(Integer idCustomer, Pageable pageable);
    
    Animal saveAnimalOfCustomer(Animal animal, Integer idCustomer);
    
    Animal update(Animal animal);
    
    Animal updateBreedOfAnimal(Integer idAnimal, Integer idBreed);
        
    void delete(Integer idAnimal);
    
}
