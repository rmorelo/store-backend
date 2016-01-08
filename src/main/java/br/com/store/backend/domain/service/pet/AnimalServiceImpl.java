package br.com.store.backend.domain.service.pet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.entity.pet.AnimalEntity;
import br.com.store.backend.domain.entity.pet.BreedEntity;
import br.com.store.backend.domain.entity.pet.WeightEntity;
import br.com.store.backend.domain.entity.customer.CustomerEntity;
import br.com.store.backend.domain.repository.pet.AnimalRepository;
import br.com.store.backend.domain.repository.pet.BreedRepository;
import br.com.store.backend.domain.repository.pet.WeightRepository;
import br.com.store.backend.domain.repository.customer.CustomerRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.pet.Animal;

@Service
@Transactional(readOnly = true)
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private WeightRepository weightRepository;
    
    @Autowired
    private BreedRepository breedRepository;
    
    @Resource
	private AnimalServiceMapper animalServiceMapper;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Animal findAnimal(Integer idAnimal) {
        AnimalEntity animalEntity = animalRepository.findOne(idAnimal);
    	
    	if(animalEntity == null){
    		throw new NotFoundException(NotFoundException.ANIMAL_NOT_FOUND);
    	}
    	
    	return AnimalConverter.convert(animalEntity);
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Page<Animal> findAnimalsByCustomer(Integer idCustomer, Pageable pageable) {
        CustomerEntity customerEntity = customerRepository.findOne(idCustomer);
        
        if(customerEntity == null){
            throw new NotFoundException(NotFoundException.CUSTOMER_NOT_FOUND);
        }
        
        List<Animal> animals = new ArrayList<Animal>();
        Page<AnimalEntity> animalEntities = animalRepository.findAllByCustomer(customerEntity, pageable);

        for (AnimalEntity animalEntity : animalEntities){
            Animal animal = AnimalConverter.convert(animalEntity);
            animals.add(animal);
        }
        
        return new PageImpl<Animal>(animals);
    }
    
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Animal saveAnimalOfCustomer(Animal animal, Integer idCustomer) {
    	if(animal.getWeight() == null && animal.getWeight().getIdWeight() == null){
            throw new NotFoundException(NotFoundException.WEIGHT_NOT_FOUND);
    	}
    	
    	WeightEntity weightEntity = weightRepository.findOne(animal.getWeight().getIdWeight());

    	if(weightEntity == null){
            throw new NotFoundException(NotFoundException.WEIGHT_NOT_FOUND);

    	}
    	
    	AnimalEntity animalEntity = AnimalConverter.convert(animal);
    	animalEntity.setWeight(weightEntity);
    	
    	animalEntity = animalRepository.save(animalEntity);
    	
    	CustomerEntity customerEntity = customerRepository.findOne(idCustomer);
        
        if(customerEntity == null){
            throw new NotFoundException(NotFoundException.CUSTOMER_NOT_FOUND);
        }
    	
        Set<AnimalEntity> animals = new HashSet<AnimalEntity>();
    	animals.add(animalEntity);
        customerEntity.setAnimals(animals);
        
        customerRepository.save(customerEntity);
        
    	return AnimalConverter.convert(animalEntity);
	}
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public Animal update(Animal animal) {    	
    	AnimalEntity animalEntity = animalRepository.findOne(animal.getIdAnimal());
    	
    	if(animalEntity == null){
    		throw new NotFoundException(NotFoundException.ANIMAL_NOT_FOUND);
    	}
    	
    	animalServiceMapper.mapAnimalToAnimalEntity(animal, animalEntity);
    	AnimalEntity animalEntitySaved = animalRepository.save(animalEntity);
        return AnimalConverter.convert(animalEntitySaved);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public Animal updateBreedOfAnimal(Integer idAnimal, Integer idBreed){
    	AnimalEntity animalEntity = animalRepository.findOne(idAnimal);
    	
    	if(animalEntity == null){
    		throw new NotFoundException(NotFoundException.ANIMAL_NOT_FOUND);
    	}
    	
    	BreedEntity breedEntity = breedRepository.findOne(idBreed);
        
        if(breedEntity == null){
            throw new NotFoundException(NotFoundException.BREED_NOT_FOUND);
        }
        
        Set<AnimalEntity> animals = new HashSet<AnimalEntity>();
        animals.add(animalEntity);
        breedEntity.setAnimals(animals);
        
        Set<BreedEntity> breeds = new HashSet<BreedEntity>();
        breeds.add(breedEntity);
        animalEntity.setBreeds(breeds);

        AnimalEntity animalEntitySaved = animalRepository.save(animalEntity);

        breedRepository.save(breedEntity);
                
        return AnimalConverter.convert(animalEntitySaved);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public void delete(Integer idAnimal) {
    	AnimalEntity animalEntity = animalRepository.findOne(idAnimal);
    	
    	if(animalEntity == null){
    		throw new NotFoundException(NotFoundException.ANIMAL_NOT_FOUND);
    	}
    	
        animalRepository.delete(animalEntity.getIdAnimal());        
    }
    
}
