package br.com.store.backend.view.endpoint.partner;

import javax.servlet.http.HttpServletRequest;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.store.backend.application.partner.PartnerApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.infrastructure.rest.selector.Selector;
import br.com.store.backend.view.resource.partner.Partner;

@RestController
public class PartnerEndpoint {

    @Autowired
    private PartnerApplication partnerApplication;
    
    @Autowired
    private HttpServletRequest request;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}", method = RequestMethod.GET)
    @Selector(resource = Partner.class)
    public ResponseEntity<Resource<Partner>> findByIdPartner(
    		@PathVariable(value = "idPartner") Integer idPartner, 
    		@RequestParam(value = "selector", required = false) String selector) {
    	
    	Partner partner = partnerApplication.findPartner(idPartner, selector);
    	partner.setUri(request.getRequestURI(), request.getQueryString());
    	
    	return new ResponseEntity<>(new Resource<Partner>(partner), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners", method = RequestMethod.POST)
    public ResponseEntity<Resource<Partner>> save(@RequestBody Partner partner) {
        Resource<Partner> partnerResource = new Resource<>(partnerApplication.save(partner));        
        return new ResponseEntity<>(partnerResource, HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}", method = RequestMethod.PUT)
    public ResponseEntity<Resource<Partner>> update(@PathVariable(value = "idPartner") Integer idPartner,
            @Validated @RequestBody Partner partner) {
        partner.setIdPartner(idPartner);
        Resource<Partner> partnerResource = new Resource<>(partnerApplication.update(partner));
        return new ResponseEntity<>(partnerResource, HttpStatus.OK);
    }
        
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}", method = RequestMethod.PATCH)
    public ResponseEntity<Resource<Partner>> updatePartial(@PathVariable(value = "idPartner") Integer idPartner,
            @Validated @RequestBody Partner partner) {
        partner.setIdPartner(idPartner);
        Resource<Partner> partnerResource = new Resource<>(partnerApplication.update(partner));
        return new ResponseEntity<>(partnerResource, HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource<Partner>> delete(@PathVariable(value = "idPartner") Integer idPartner){
        partnerApplication.delete(idPartner);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/addresses/{idAddress}", method = RequestMethod.PATCH)
    public ResponseEntity<Resource<Partner>> updatePartial(@PathVariable(value = "idPartner") Integer idPartner,
    		@PathVariable(value = "idAddress") Integer idAddress) {
        Resource<Partner> partnerResource = new Resource<>(partnerApplication.updateAddress(idPartner, idAddress));
        return new ResponseEntity<>(partnerResource, HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/addresses/{idAddress}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource<Partner>> delete(@PathVariable(value = "idPartner") Integer idPartner,
    		@PathVariable(value = "idAddress") Integer idAddress) {
//        partnerApplication.delete(idPartner, idAddress);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}