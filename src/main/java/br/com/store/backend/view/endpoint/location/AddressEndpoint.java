package br.com.store.backend.view.endpoint.location;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

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

import br.com.store.backend.application.location.AddressApplication;
import br.com.store.backend.domain.entity.location.AddressTypeEnum;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.infrastructure.rest.selector.Selector;
import br.com.store.backend.view.resource.location.Address;
import br.com.store.backend.view.resource.location.PostalArea;
import br.com.store.backend.view.resource.partner.Partner;

@RestController
public class AddressEndpoint {
	
    @Autowired
    private AddressApplication addressApplication;
    
    @Autowired
    private HttpServletRequest request;
    
    @Selector(resource = PostalArea.class)
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/addresses/{idAddress}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<Address>> findPostalArea(@PathVariable Integer idAddress, 
            @RequestParam(value = "selector", required = false) String selector) {
        
    	Address address = addressApplication.findAddress(idAddress, selector);
    	address.setUri(request.getRequestURI(), request.getQueryString());
        
        return new ResponseEntity<>(new Resource<Address>(address), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/addresses", method = RequestMethod.POST)
    public ResponseEntity<Resource<Address>> save(@PathVariable(value = "idPartner") Integer idPartner,
    		@RequestBody Address address) {
        Address addressResource = addressApplication.saveAddressOfPartner(idPartner, address);
        addressResource.setUri(request.getRequestURI(), request.getQueryString());
        
        return new ResponseEntity<>(new Resource<Address>(addressResource), HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/addresses/types", method = RequestMethod.GET)
    public ResponseEntity<Resource<AddressTypeEnum[]>> getAddressType() {
        Resource<AddressTypeEnum[]> addressTypeEnum = new Resource<>(AddressTypeEnum.values());
        return new ResponseEntity<>(addressTypeEnum, HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/addresses/{idAddress}", method = RequestMethod.PATCH)
    public ResponseEntity<Resource<Address>> updatePartial(@PathVariable(value = "idAddress") Integer idAddress,
            @Validated @RequestBody Address address) {
    	address.setIdAddress(idAddress);
        Address addressResource = addressApplication.update(address);
        addressResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Address>(addressResource), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/addresses/{idAddress}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource<Partner>> delete(@PathVariable(value = "idAddress") Integer idAddress) {
        addressApplication.delete(idAddress);
        return new ResponseEntity<>(HttpStatus.OK);
    }

      
}