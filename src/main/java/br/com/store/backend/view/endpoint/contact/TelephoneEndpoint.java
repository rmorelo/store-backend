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

import br.com.store.backend.application.contact.TelephoneApplication;
import br.com.store.backend.domain.entity.contact.TelephoneTypeEnum;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.view.resource.contact.Telephone;

@RestController
public class TelephoneEndpoint {

    @Autowired
    private TelephoneApplication telephoneApplication;
    
	@Autowired
    private HttpServletRequest request;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/telephones", method = RequestMethod.POST)
    public ResponseEntity<Resource<Telephone>> saveTelephoneOfPartner(@PathVariable(value = "idPartner") Integer idPartner, 
    		@RequestBody Telephone telephone) {
        Telephone telephoneResource = telephoneApplication.saveTelephoneOfPartner(idPartner, telephone);
        telephoneResource.setUri(request.getRequestURI(), request.getQueryString());
        
        return new ResponseEntity<>(new Resource<>(telephoneResource), HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/telephones/types", method = RequestMethod.GET)
    public ResponseEntity<Resource<TelephoneTypeEnum[]>> getTelephoneType() {
        Resource<TelephoneTypeEnum[]> telephoneResource = new Resource<>(TelephoneTypeEnum.values());
        return new ResponseEntity<>(telephoneResource, HttpStatus.CREATED);
    }
    
    
}