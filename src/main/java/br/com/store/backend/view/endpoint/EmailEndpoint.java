package br.com.store.backend.view.endpoint;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.store.backend.application.partner.EmailApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.view.resource.partner.Email;

@RestController
public class EmailEndpoint {

    @Autowired
    private EmailApplication emailApplication;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/emails", method = RequestMethod.GET)
    public ResponseEntity<Resource<Email>> findByIdPartner(
    		@PathVariable(value = "idPartner") Integer idPartner) {

        
    	return null;
    }   
}