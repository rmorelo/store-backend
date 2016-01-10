package br.com.store.backend.view.endpoint.location;

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

import br.com.store.backend.application.location.CityApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.infrastructure.rest.selector.Selector;
import br.com.store.backend.view.resource.location.City;

@RestController
public class CityEndpoint {
	
    @Autowired
    private CityApplication cityApplication;
    
    @Autowired
    private HttpServletRequest request;
    
    @Selector(resource = City.class)
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/districts/{idDistrict}/cities", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<City>> findCityByDistric(@PathVariable(value = "idDistrict") Integer idDistrict, 
            @RequestParam(value = "selector", required = false) String selector) {
    	
    	City city = cityApplication.findCityByDistrict(idDistrict, selector);
        city.setUri(request.getRequestURI(), request.getQueryString());
        
        return new ResponseEntity<>(new Resource<City>(city), HttpStatus.OK);
    }
    
    @Selector(resource = City.class)
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/cities/{idCity}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<City>> findCity(@PathVariable(value = "idCity") Integer idCity, 
            @RequestParam(value = "selector", required = false) String selector) {
        
    	City city = cityApplication.findCity(idCity, selector);
        city.setUri(request.getRequestURI(), request.getQueryString());
    	
        return new ResponseEntity<>(new Resource<City>(city), HttpStatus.OK);
    }
      
}