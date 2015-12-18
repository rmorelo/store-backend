package br.com.store.backend.view.endpoint;

import javax.ws.rs.core.MediaType;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.store.backend.application.partner.DistrictApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.infrastructure.rest.selector.Selector;
import br.com.store.backend.view.resource.partner.District;
import br.com.store.backend.view.resource.partner.PostalArea;

@RestController
public class DistrictEndpoint {
	
    @Autowired
    private DistrictApplication districtApplication;
    
    @Selector(resource = PostalArea.class)
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/districts/{idDistrict}/cities", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<District>> findByCodPostalArea(@PathVariable Integer idDistrict) {
        District district = districtApplication.findCityByIdDistrict(idDistrict);
        return new ResponseEntity<>(new Resource<District>(district), HttpStatus.OK);
    }
      
}