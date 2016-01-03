package br.com.store.backend.view.endpoint.person;

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
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/individuals", method = RequestMethod.GET)
    public ResponseEntity<Resource<Individual>> findIndividualByPartner(
    		@PathVariable(value = "idPartner") Integer idPartner) {
    	Individual individual = individualApplication.findIndividualByPartner(idPartner);
    	return new ResponseEntity<>(new Resource<Individual>(individual), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/individuals", method = RequestMethod.POST)
    public ResponseEntity<Resource<Individual>> saveIndividualOfPartner(@PathVariable(value = "idPartner") Integer idPartner, 
    		@RequestBody Individual individual) {
        Resource<Individual> individualResource = new Resource<>(individualApplication.saveIndividualOfPartner(idPartner, individual));        
        return new ResponseEntity<>(individualResource, HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/individuals/{idIndividual}", method = RequestMethod.PUT)
    public ResponseEntity<Resource<Individual>> update(@PathVariable(value = "idIndividual") Integer idIndividual,
            @Validated @RequestBody Individual individual) {
    	individual.setIdIndividual(idIndividual);
        Resource<Individual> individualResource = new Resource<>(individualApplication.update(individual));
        return new ResponseEntity<>(individualResource, HttpStatus.OK);
    }
        
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/individuals/{idIndividual}", method = RequestMethod.PATCH)
    public ResponseEntity<Resource<Individual>> updatePartial(@PathVariable(value = "idIndividual") Integer idIndividual,
            @Validated @RequestBody Individual individual) {
    	individual.setIdIndividual(idIndividual);
        Resource<Individual> individualResource = new Resource<>(individualApplication.update(individual));
        return new ResponseEntity<>(individualResource, HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/individuals/{idIndividual}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource<Individual>> delete(@PathVariable(value = "idIndividual") Integer idIndividual){
    	individualApplication.delete(idIndividual);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}