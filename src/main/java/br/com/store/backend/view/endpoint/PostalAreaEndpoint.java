package br.com.store.backend.view.endpoint;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.store.backend.application.partner.PostalAreaApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.infrastructure.rest.selector.Selector;
import br.com.store.backend.view.resource.partner.PostalArea;
import br.com.store.backend.view.resource.partner.PostalAreaLinks;

@RestController
public class PostalAreaEndpoint {
	
    @Autowired
    private PostalAreaApplication postalAreaApplication;
    
    @Selector(resource = PostalArea.class)
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/postalareas{codPostalArea}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<PostalArea>> findByCodPostalArea(
            @MatrixVariable(value = "codPostalArea", required = true) String codPostalArea, @QueryParam("selector") String[] selector) {
        PostalArea postalArea = postalAreaApplication.findByCodPostalArea(codPostalArea, selector);
        
        postalArea.add(linkTo(methodOn(PostalAreaEndpoint.class).findByCodPostalArea(codPostalArea, selector)).slash(postalArea.getIdPostalArea()).withSelfRel());
        
    	return new ResponseEntity<>(new Resource<PostalArea>(postalArea), HttpStatus.OK);
    }
      
}