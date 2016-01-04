package br.com.store.backend.view.endpoint.person;

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

import br.com.store.backend.application.person.IndividualApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.view.resource.person.Individual;

@RestController
public class IndividualEndpoint {

    @Autowired
    private IndividualApplication individualApplication;
    
    @Autowired
    private HttpServletRequest request;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/individuals", method = RequestMethod.GET)
    public ResponseEntity<Resource<Individual>> findIndividualByPartner(
    		@PathVariable(value = "idPartner") Integer idPartner) {
    	Individual individual = individualApplication.findIndividualByPartner(idPartner);
    	
    	individual.setUri(request.getRequestURI(), request.getQueryString());
    	
    	return new ResponseEntity<>(new Resource<Individual>(individual), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/individuals/{idIndividual}", method = RequestMethod.GET)
    public ResponseEntity<Resource<Individual>> findIndividual(
    		@PathVariable(value = "idIndividual") Integer idIndividual) {
    	Individual individual = individualApplication.findIndividual(idIndividual);
    	
    	individual.setUri(request.getRequestURI(), request.getQueryString());
    	
    	return new ResponseEntity<>(new Resource<Individual>(individual), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/individuals", method = RequestMethod.POST)
    public ResponseEntity<Resource<Individual>> saveIndividualOfPartner(@PathVariable(value = "idPartner") Integer idPartner, 
    		@RequestBody Individual individual) {
    	Individual individualResource = individualApplication.saveIndividualOfPartner(idPartner, individual);
        
    	individualResource.setUri(request.getRequestURI(), request.getQueryString());
        
        return new ResponseEntity<>(new Resource<Individual>(individualResource), HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/individuals/{idIndividual}", method = RequestMethod.PUT)
    public ResponseEntity<Resource<Individual>> update(@PathVariable(value = "idIndividual") Integer idIndividual,
            @Validated @RequestBody Individual individual) {
    	
    	individual.setIdIndividual(idIndividual);
    	Individual individualResource = individualApplication.update(individual);
        individualResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Individual>(individualResource), HttpStatus.OK);
    }
        
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/individuals/{idIndividual}", method = RequestMethod.PATCH)
    public ResponseEntity<Resource<Individual>> updatePartial(@PathVariable(value = "idIndividual") Integer idIndividual,
            @Validated @RequestBody Individual individual) {
    	
    	individual.setIdIndividual(idIndividual);
    	Individual individualResource = individualApplication.update(individual);
        individualResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Individual>(individualResource), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/individuals/{idIndividual}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource<Individual>> delete(@PathVariable(value = "idIndividual") Integer idIndividual){
    	individualApplication.delete(idIndividual);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}