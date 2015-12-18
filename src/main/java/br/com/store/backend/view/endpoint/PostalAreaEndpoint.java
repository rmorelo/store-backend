package br.com.store.backend.view.endpoint;

import javax.ws.rs.core.MediaType;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.store.backend.application.partner.PostalAreaApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.infrastructure.rest.selector.Selector;
import br.com.store.backend.view.resource.partner.PostalArea;

@RestController
public class PostalAreaEndpoint {
	
    @Autowired
    private PostalAreaApplication postalAreaApplication;
    
    @Selector(resource = PostalArea.class)
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/{postalareas}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<PostalArea>> findByCodPostalArea(@PathVariable String postalareas,
            @MatrixVariable(value = "codPostalArea", required = true) String codPostalArea, 
            @RequestParam(value = "selector", required = false) String selector) {
        PostalArea postalArea = postalAreaApplication.findByCodPostalArea(codPostalArea, selector);
        
        if(selector != null)
        	postalArea.setUri(postalArea.getUri() + "?selector=" + selector);
    	
        return new ResponseEntity<>(new Resource<PostalArea>(postalArea), HttpStatus.OK);
    }
      
}