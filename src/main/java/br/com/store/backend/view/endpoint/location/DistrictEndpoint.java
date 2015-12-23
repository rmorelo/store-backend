package br.com.store.backend.view.endpoint.location;

import java.util.Collection;

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

import br.com.store.backend.application.location.DistrictApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.infrastructure.rest.selector.Selector;
import br.com.store.backend.view.resource.location.District;

@RestController
public class DistrictEndpoint {
	
    @Autowired
    private DistrictApplication districtApplication;
    
    @Selector(resource = District.class)
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/postalareas/{idPostalArea}/districts", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<Collection<District>>> findDistricts(@PathVariable(value = "idPostalArea") Integer idPostalArea, 
            @RequestParam(value = "selector", required = false) String selector) {
    	Collection<District> districts = districtApplication.findDistrictsByPostalArea(idPostalArea, selector);
        
        if(selector != null){
        	for(District district : districts){
        		district.setUri(district.getUri() + "?selector=" + selector);
        	}
        }
        return new ResponseEntity<>(new Resource<Collection<District>>(districts), HttpStatus.OK);
    }
    
    @Selector(resource = District.class)
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/districts/{idDistrict}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<District>> findDistrict(@PathVariable(value = "idDistrict") Integer idDistrict, 
            @RequestParam(value = "selector", required = false) String selector) {
        District district = districtApplication.findDistrict(idDistrict, selector);
        
        if(selector != null){
            district.setUri(district.getUri() + "?selector=" + selector);
        }
        return new ResponseEntity<>(new Resource<District>(district), HttpStatus.OK);
    }
      
}