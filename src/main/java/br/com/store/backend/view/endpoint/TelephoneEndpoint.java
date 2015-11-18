package br.com.store.backend.view.endpoint;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.store.backend.application.partner.TelephoneApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.view.resource.partner.Telephone;

@RestController
public class TelephoneEndpoint {

    @Autowired
    private TelephoneApplication telephoneApplication;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/telephones", method = RequestMethod.POST)
    public ResponseEntity<Resource<Telephone>> save(@PathVariable(value = "idPartner") Integer idPartner, 
    		@RequestBody Telephone telephone) {
        Resource<Telephone> telephoneResource = new Resource<>(telephoneApplication.save(idPartner, telephone));        
        return new ResponseEntity<>(telephoneResource, HttpStatus.CREATED);
    }
    
}