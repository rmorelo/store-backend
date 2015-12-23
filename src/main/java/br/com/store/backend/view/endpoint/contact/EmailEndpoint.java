package br.com.store.backend.view.endpoint.contact;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.store.backend.application.contact.EmailApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.view.resource.contact.Email;

@RestController
public class EmailEndpoint {

    @Autowired
    private EmailApplication emailApplication;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/emails", method = RequestMethod.POST)
    public ResponseEntity<Resource<Email>> save(@PathVariable(value = "idPartner") Integer idPartner, 
    		@RequestBody Email email) {
        Resource<Email> emailResource = new Resource<>(emailApplication.save(idPartner, email));        
        return new ResponseEntity<>(emailResource, HttpStatus.CREATED);
    }
    
}