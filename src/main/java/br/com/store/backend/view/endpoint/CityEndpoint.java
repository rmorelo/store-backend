package br.com.store.backend.view.endpoint;

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

import br.com.store.backend.application.partner.CityApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.infrastructure.rest.selector.Selector;
import br.com.store.backend.view.resource.partner.City;

@RestController
public class CityEndpoint {
	
    @Autowired
    private CityApplication cityApplication;
    
    @Selector(resource = City.class)
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/districts/{idDistrict}/cities", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<City>> findDistricts(@PathVariable(value = "idDistrict") Integer idDistrict, 
            @RequestParam(value = "selector", required = false) String selector) {
    	City city = cityApplication.findCity(idDistrict, selector);
        
        if(selector != null){
        	city.setUri(city.getUri() + "?selector=" + selector);
        }
        
        return new ResponseEntity<>(new Resource<City>(city), HttpStatus.OK);
    }
      
}