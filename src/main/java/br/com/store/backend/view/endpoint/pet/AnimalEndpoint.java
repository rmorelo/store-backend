package br.com.store.backend.view.endpoint.pet;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.store.backend.application.pet.AnimalApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.infrastructure.rest.selector.Selector;
import br.com.store.backend.view.resource.pet.Animal;

@RestController
public class AnimalEndpoint {

    @Autowired
    private AnimalApplication animalApplication;
    
    @Autowired
    private HttpServletRequest request;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/animals/{idAnimal}", method = RequestMethod.GET)
    @Selector(resource = Animal.class)
    public ResponseEntity<Resource<Animal>> findByIdAnimal(
    		@PathVariable(value = "idAnimal") Integer idAnimal, 
    		@RequestParam(value = "selector", required = false) String[] selectors) {
    	Animal animal = animalApplication.findAnimal(idAnimal, selectors);
    	animal.setUri(request.getRequestURI(), request.getQueryString());
    	
    	return new ResponseEntity<>(new Resource<Animal>(animal), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/customers/{idCustomer}/animals", method = RequestMethod.GET)    
    public ResponseEntity<Resource<Collection<Animal>>> findAnimalsByIdCustomer(
            @PathVariable(value = "idCustomer") Integer idCustomer) {
        Collection<Animal> animals = animalApplication.findAnimalsByIdCustomer(idCustomer);
        
        for(Animal animal : animals){
            animal.setUri(request.getRequestURI(), request.getQueryString());
        }
        
        return new ResponseEntity<>(new Resource<Collection<Animal>>(animals), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/customers/{idCustomer}/animals", method = RequestMethod.POST)
    public ResponseEntity<Resource<Animal>> save(@RequestBody Animal animal, Integer idCustomer) {
    	Animal animalResource = animalApplication.saveAnimalOfCustomer(animal, idCustomer);
    	animalResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Animal>(animalResource), HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/animals/{idAnimal}", method = RequestMethod.PUT)
    public ResponseEntity<Resource<Animal>> update(@PathVariable(value = "idAnimal") Integer idAnimal,
            @Validated @RequestBody Animal animal) {
        animal.setIdAnimal(idAnimal);
        Animal animalResource = animalApplication.update(animal);
        animalResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Animal>(animalResource), HttpStatus.OK);
    }
        
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/animals/{idAnimal}", method = RequestMethod.PATCH)
    public ResponseEntity<Resource<Animal>> updatePartial(@PathVariable(value = "idAnimal") Integer idAnimal,
            @Validated @RequestBody Animal animal) {
        animal.setIdAnimal(idAnimal);
        Animal animalResource = animalApplication.update(animal);
        animalResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Animal>(animalResource), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/animals/{idAnimal}/breeds/{idBreed}", method = RequestMethod.PATCH)
    public ResponseEntity<Resource<Animal>> updatePartnerOfCustomer(@PathVariable(value = "idAnimal") Integer idAnimal, 
            @PathVariable(value = "idBreed") Integer idBreed) {
    	Animal animalResource = animalApplication.updateBreedOfAnimal(idAnimal, idBreed);
    	animalResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Animal>(animalResource), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/animals/{idAnimal}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource<Animal>> delete(@PathVariable(value = "idAnimal") Integer idAnimal){
        animalApplication.delete(idAnimal);
        return new ResponseEntity<>(HttpStatus.OK);
    }    
}