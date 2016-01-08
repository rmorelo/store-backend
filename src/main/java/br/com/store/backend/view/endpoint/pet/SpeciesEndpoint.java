package br.com.store.backend.view.endpoint.pet;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.store.backend.application.pet.SpeciesApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.infrastructure.rest.selector.Selector;
import br.com.store.backend.view.resource.pet.Species;

@RestController
public class SpeciesEndpoint {
	
    @Autowired
    private SpeciesApplication speciesApplication;

    @Autowired
    private HttpServletRequest request;
    
    @Selector(resource = Species.class)
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/breeds/{idBreed}/species", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<Species>> findSpeciesByBreed(@PathVariable(value = "idBreed") Integer idBreed, 
            @RequestParam(value = "selector", required = false) String selector) {
        
    	Species species = speciesApplication.findSpeciesByBreed(idBreed, selector);
        species.setUri(request.getRequestURI(), request.getQueryString());
        
        return new ResponseEntity<>(new Resource<Species>(species), HttpStatus.OK);
    }
    
    @Selector(resource = Species.class)
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/species/{idSpecies}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<Species>> findSpecies(@PathVariable(value = "idSpecies") Integer idSpecies, 
            @RequestParam(value = "selector", required = false) String selector) {
        
    	Species species = speciesApplication.findSpecies(idSpecies, selector);
        species.setUri(request.getRequestURI(), request.getQueryString());
        
        return new ResponseEntity<>(new Resource<Species>(species), HttpStatus.OK);
    }
}