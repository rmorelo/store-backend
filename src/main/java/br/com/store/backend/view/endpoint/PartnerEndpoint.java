package br.com.store.backend.view.endpoint;

import br.com.store.backend.application.partner.PartnerApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.view.resource.partner.Partner;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartnerEndpoint {

    @Autowired
    private PartnerApplication partnerApplication;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}", method = RequestMethod.GET)
    public ResponseEntity<Resource<Partner>> getPartner(
    		@PathVariable(value = "idPartner") Integer idPartner) {

    	Partner partner = partnerApplication.findByIdPartner(idPartner);
        return new ResponseEntity<>(new Resource<Partner>(partner), HttpStatus.OK);

    }
    

}
