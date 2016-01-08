package br.com.store.backend.view.endpoint.customer;

import javax.servlet.http.HttpServletRequest;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.store.backend.application.customer.CustomerApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.infrastructure.rest.selector.Selector;
import br.com.store.backend.view.resource.customer.Customer;

@RestController
public class CustomerEndpoint {

    @Autowired
    private CustomerApplication customerApplication;
    
    @Autowired
    private HttpServletRequest request;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/customers/{idCustomer}", method = RequestMethod.GET)
    @Selector(resource = Customer.class)
    public ResponseEntity<Resource<Customer>> findByIdCustomer(
    		@PathVariable(value = "idCustomer") Integer idCustomer, 
    		@RequestParam(value = "selector", required = false) String[] selectors) {
    	Customer customer = customerApplication.findCustomer(idCustomer, selectors);
    	customer.setUri(request.getRequestURI(), request.getQueryString());
    	
    	return new ResponseEntity<>(new Resource<Customer>(customer), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/customers", method = RequestMethod.GET)    
    public ResponseEntity<Resource<Page<Customer>>> findCustomersByIdPartner(
            @PathVariable(value = "idPartner") Integer idPartner,
            Pageable pageable) {
        Page<Customer> customers = customerApplication.findCustomersByIdPartner(idPartner, pageable);
        
        for(Customer customer : customers){
            customer.setUri(request.getRequestURI(), request.getQueryString());
        }
        
        return new ResponseEntity<>(new Resource<Page<Customer>>(customers), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<Resource<Customer>> save(@RequestBody Customer customer) {
    	Customer customerResource = customerApplication.save(customer);
    	customerResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Customer>(customerResource), HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/customers/{idCustomer}", method = RequestMethod.PUT)
    public ResponseEntity<Resource<Customer>> update(@PathVariable(value = "idCustomer") Integer idCustomer,
            @Validated @RequestBody Customer customer) {
        customer.setIdCustomer(idCustomer);
        Customer customerResource = customerApplication.update(customer);
        customerResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Customer>(customerResource), HttpStatus.OK);
    }
        
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/customers/{idCustomer}", method = RequestMethod.PATCH)
    public ResponseEntity<Resource<Customer>> updatePartial(@PathVariable(value = "idCustomer") Integer idCustomer,
            @Validated @RequestBody Customer customer) {
        customer.setIdCustomer(idCustomer);
        Customer customerResource = customerApplication.update(customer);
        customerResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Customer>(customerResource), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/customers/{idCustomer}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource<Customer>> delete(@PathVariable(value = "idCustomer") Integer idCustomer){
        customerApplication.delete(idCustomer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}