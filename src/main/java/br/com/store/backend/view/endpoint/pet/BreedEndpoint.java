package br.com.store.backend.view.endpoint.pet;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import br.com.store.backend.application.pet.BreedApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.view.resource.pet.Breed;

@RestController
public class BreedEndpoint {

    @Autowired
    private BreedApplication breedApplication;
    
    @Autowired
    private HttpServletRequest request;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/breeds/{idBreed}", method = RequestMethod.GET)
    public ResponseEntity<Resource<Breed>> findByIdBreed(
    		@PathVariable(value = "idBreed") Integer idBreed) {
    	Breed breed = breedApplication.findBreed(idBreed);
    	breed.setUri(request.getRequestURI(), request.getQueryString());
    	
    	return new ResponseEntity<>(new Resource<Breed>(breed), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/breeds", method = RequestMethod.GET)
    public ResponseEntity<Resource<Collection<Breed>>> findBreeds() {
    	Collection<Breed> breeds = breedApplication.findBreeds();
    	Collection<Breed> breedsResult = new ArrayList<Breed>();
    	
    	for(Breed breed : breeds){
        	breed.setUri(request.getRequestURI(), request.getQueryString());
        	breedsResult.add(breed);
    	}
    	
    	return new ResponseEntity<>(new Resource<Collection<Breed>>(breedsResult), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/breeds", method = RequestMethod.POST)
    public ResponseEntity<Resource<Breed>> saveBreed(@RequestBody Breed breed) {
    	Breed breedResource = breedApplication.saveBreed(breed);
    	breedResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Breed>(breedResource), HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/breeds/{idBreed}", method = RequestMethod.PUT)
    public ResponseEntity<Resource<Breed>> update(@PathVariable(value = "idBreed") Integer idBreed,
            @Validated @RequestBody Breed breed) {
        breed.setIdBreed(idBreed);
        Breed breedResource = breedApplication.update(breed);
        breedResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Breed>(breedResource), HttpStatus.OK);
    }
        
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/breeds/{idBreed}", method = RequestMethod.PATCH)
    public ResponseEntity<Resource<Breed>> updatePartial(@PathVariable(value = "idBreed") Integer idBreed,
            @Validated @RequestBody Breed breed) {
        breed.setIdBreed(idBreed);
        Breed breedResource = breedApplication.update(breed);
        breedResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Breed>(breedResource), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/breeds/{idBreed}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource<Breed>> delete(@PathVariable(value = "idBreed") Integer idBreed){
        breedApplication.delete(idBreed);
        return new ResponseEntity<>(HttpStatus.OK);
    }    
}