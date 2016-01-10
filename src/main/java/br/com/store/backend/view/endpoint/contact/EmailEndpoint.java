package br.com.store.backend.view.endpoint.contact;

import javax.servlet.http.HttpServletRequest;

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
    
    @Autowired
    private HttpServletRequest request;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/emails", method = RequestMethod.POST)
    public ResponseEntity<Resource<Email>> saveEmailOfPartner(@PathVariable(value = "idPartner") Integer idPartner, 
    		@RequestBody Email email) {
        Email emailResource = emailApplication.saveEmailOfPartner(idPartner, email);
        emailResource.setUri(request.getRequestURI(), request.getQueryString());
        
    	return new ResponseEntity<>(new Resource<Email>(emailResource), HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/customers/{idCustomer}/emails", method = RequestMethod.POST)
    public ResponseEntity<Resource<Email>> saveEmailOfCustomer(@PathVariable(value = "idCustomer") Integer idCustomer, 
    		@RequestBody Email email) {
        Email emailResource = emailApplication.saveEmailOfCustomer(idCustomer, email);
        emailResource.setUri(request.getRequestURI(), request.getQueryString());
        
    	return new ResponseEntity<>(new Resource<Email>(emailResource), HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/customers/{idCustomer}/emails", method = RequestMethod.GET)
    public ResponseEntity<Resource<Email>> findEmailByCustomer(@PathVariable(value = "idCustomer") Integer idCustomer){
    	Email emailResource = emailApplication.findEmailByCustomer(idCustomer);
    	emailResource.setUri(request.getRequestURI(), request.getQueryString());
        
    	return new ResponseEntity<>(new Resource<Email>(emailResource), HttpStatus.OK);
    }
	
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/emails", method = RequestMethod.GET)
    public ResponseEntity<Resource<Email>> findEmailByPartner(@PathVariable(value = "idPartner") Integer idPartner){
    	Email emailResource = emailApplication.findEmailByPartner(idPartner);
    	emailResource.setUri(request.getRequestURI(), request.getQueryString());
        
    	return new ResponseEntity<>(new Resource<Email>(emailResource), HttpStatus.OK);
    }
    
}