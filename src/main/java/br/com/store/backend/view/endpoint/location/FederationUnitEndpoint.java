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

import br.com.store.backend.application.location.FederationUnitApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.infrastructure.rest.selector.Selector;
import br.com.store.backend.view.resource.location.FederationUnit;

@RestController
public class FederationUnitEndpoint {
	
    @Autowired
    private FederationUnitApplication federationUnitApplication;

    @Autowired
    private HttpServletRequest request;
    
    @Selector(resource = FederationUnit.class)
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/cities/{idCity}/federation-units", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<FederationUnit>> findFederationUnitByCity(@PathVariable(value = "idCity") Integer idCity, 
            @RequestParam(value = "selector", required = false) String selector) {
        
    	FederationUnit federationUnit = federationUnitApplication.findFederationUnitByCity(idCity, selector);
        federationUnit.setUri(request.getRequestURI(), request.getQueryString());
        
        return new ResponseEntity<>(new Resource<FederationUnit>(federationUnit), HttpStatus.OK);
    }
    
    @Selector(resource = FederationUnit.class)
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/federation-units/{idFederationUnit}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<FederationUnit>> findFederationUnit(@PathVariable(value = "idFederationUnit") Integer idFederationUnit, 
            @RequestParam(value = "selector", required = false) String selector) {
        
    	FederationUnit federationUnit = federationUnitApplication.findFederationUnit(idFederationUnit, selector);
        federationUnit.setUri(request.getRequestURI(), request.getQueryString());
        
        return new ResponseEntity<>(new Resource<FederationUnit>(federationUnit), HttpStatus.OK);
    }
}