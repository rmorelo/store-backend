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

import br.com.store.backend.application.pet.WeightApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.view.resource.pet.Weight;

@RestController
public class WeightEndpoint {

    @Autowired
    private WeightApplication weightApplication;
    
    @Autowired
    private HttpServletRequest request;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/weights/{idWeight}", method = RequestMethod.GET)
    public ResponseEntity<Resource<Weight>> findByIdWeight(
    		@PathVariable(value = "idWeight") Integer idWeight) {
    	Weight weight = weightApplication.findWeight(idWeight);
    	weight.setUri(request.getRequestURI(), request.getQueryString());
    	
    	return new ResponseEntity<>(new Resource<Weight>(weight), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/animals/{idAnimal}/weights", method = RequestMethod.GET)
    public ResponseEntity<Resource<Weight>> findWeightByAnimal(
    		@PathVariable(value = "idAnimal") Integer idAnimal) {
    	Weight weight = weightApplication.findWeightByAnimal(idAnimal);
    	weight.setUri(request.getRequestURI(), request.getQueryString());
    	
    	return new ResponseEntity<>(new Resource<Weight>(weight), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/weights", method = RequestMethod.GET)
    public ResponseEntity<Resource<Collection<Weight>>> findWeights() {
    	Collection<Weight> weights = weightApplication.findWeights();
    	Collection<Weight> weightsResult = new ArrayList<Weight>();
    	
    	for(Weight weight : weights){
        	weight.setUri(request.getRequestURI(), request.getQueryString());
        	weightsResult.add(weight);
    	}
    	
    	return new ResponseEntity<>(new Resource<Collection<Weight>>(weightsResult), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/weights", method = RequestMethod.POST)
    public ResponseEntity<Resource<Weight>> saveWeight(@RequestBody Weight weight) {
    	Weight weightResource = weightApplication.saveWeight(weight);
    	weightResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Weight>(weightResource), HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/weights/{idWeight}", method = RequestMethod.PUT)
    public ResponseEntity<Resource<Weight>> update(@PathVariable(value = "idWeight") Integer idWeight,
            @Validated @RequestBody Weight weight) {
        weight.setIdWeight(idWeight);
        Weight weightResource = weightApplication.update(weight);
        weightResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Weight>(weightResource), HttpStatus.OK);
    }
        
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/weights/{idWeight}", method = RequestMethod.PATCH)
    public ResponseEntity<Resource<Weight>> updatePartial(@PathVariable(value = "idWeight") Integer idWeight,
            @Validated @RequestBody Weight weight) {
        weight.setIdWeight(idWeight);
        Weight weightResource = weightApplication.update(weight);
        weightResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Weight>(weightResource), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/weights/{idWeight}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource<Weight>> delete(@PathVariable(value = "idWeight") Integer idWeight){
        weightApplication.delete(idWeight);
        return new ResponseEntity<>(HttpStatus.OK);
    }    
}