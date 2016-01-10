package br.com.store.backend.application.pet;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.service.pet.AnimalService;
import br.com.store.backend.domain.service.pet.BreedService;
import br.com.store.backend.domain.service.pet.WeightService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.pet.Animal;
import br.com.store.backend.view.resource.pet.Breed;
import br.com.store.backend.view.resource.pet.Weight;

@Service
@Transactional(readOnly = true)
public class AnimalApplicationImpl implements AnimalApplication {

    @Autowired
    private AnimalService animalService;
    
    @Autowired
    private WeightService weightService; 
    
    @Autowired
    private BreedService breedService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Animal findAnimal(Integer idAnimal, String[] selectors) {
    	Animal animal = animalService.findAnimal(idAnimal);
    	addSelector(animal, selectors);
    	
    	return animal;
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Collection<Animal> findAnimalsByIdCustomer(Integer idCustomer) {
    	Collection<Animal> animals = animalService.findAnimalsByCustomer(idCustomer);
        
        return animals;
    }
    
    private void addSelector(Animal animal, String[] selectors) {
        if (selectors != null){
            List<String> selectorList = Arrays.asList(selectors);
            
            if(selectorList.contains(Animal.BREEDS)){
            	addBreeds(animal);
            }
            
            if(selectorList.contains(Animal.WEIGHTS)){
            	addWeight(animal);
            }
        }        
    }

    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Animal saveAnimalOfCustomer(Animal animal, Integer idCustomer) {
        return animalService.saveAnimalOfCustomer(animal, idCustomer);
    }
    
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public Animal update(Animal animal) {
        return animalService.update(animal);
    }
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
	public Animal updateBreedOfAnimal(Integer idAnimal, Integer idBreed){
		return animalService.updateBreedOfAnimal(idAnimal, idBreed);
	}
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public void delete(Integer idAnimal) {
        animalService.delete(idAnimal);
    }
	
	private void addWeight(Animal animal) {
		Weight weight = weightService.findWeightByAnimal(animal.getIdAnimal());
		animal.setWeight(weight);
	}
	
	private void addBreeds(Animal animal){
		Collection<Breed> breeds = breedService.findBreedByAnimal(animal.getIdAnimal());
		animal.setBreeds(breeds);
	}
		
}
