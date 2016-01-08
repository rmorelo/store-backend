package br.com.store.backend.application.pet;

import java.util.Arrays;
import java.util.List;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.service.pet.AnimalService;
import br.com.store.backend.domain.service.location.AddressService;
import br.com.store.backend.domain.service.customer.CustomerService;
import br.com.store.backend.domain.service.person.CompanyService;
import br.com.store.backend.domain.service.person.IndividualService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.pet.Animal;

@Service
@Transactional(readOnly = true)
public class AnimalApplicationImpl implements AnimalApplication {

    @Autowired
    private AnimalService animalService;
        
    @Autowired
    private IndividualService individualService;
    
    @Autowired
    private CompanyService companyService;
    
    @Autowired
    private AddressService addressService;
    
    @Autowired
    private CustomerService customerService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Animal findAnimal(Integer idAnimal, String[] selectors) {
    	Animal animal = animalService.findAnimal(idAnimal);
    	addSelector(animal, selectors);
    	
    	return animal;
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Page<Animal> findAnimalsByIdCustomer(Integer idCustomer, Pageable pageable) {
    	Page<Animal> animals = animalService.findAnimalsByCustomer(idCustomer, pageable);
        
        return animals;
    }
    
    private void addSelector(Animal animal, String[] selectors) {
        if (selectors != null){
            List<String> selectorList = Arrays.asList(selectors);
            
            if(selectorList.contains(Animal.CUSTOMERS)){
                
            }
            
            if(selectorList.contains(Animal.BREEDS)){
                
            }
            
            if(selectorList.contains(Animal.WEIGHTS)){
                
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
		
}
