package br.com.store.backend.view.endpoint;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.store.backend.application.partner.PartnerApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.view.resource.partner.Company;
import br.com.store.backend.view.resource.partner.Individual;
import br.com.store.backend.view.resource.partner.Partner;

@RestController
public class PartnerEndpoint {

    @Autowired
    private PartnerApplication partnerApplication;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}", method = RequestMethod.GET)
    public ResponseEntity<Resource<Partner>> findByIdPartner(
    		@PathVariable(value = "idPartner") Integer idEmail) {
    	Partner partner = partnerApplication.findByIdPartner(idEmail);
    	return new ResponseEntity<>(new Resource<Partner>(partner), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/company", method = RequestMethod.POST)
    public ResponseEntity<Resource<Company>> save(@RequestBody Company company) {
        Resource<Company> companyResource = new Resource<>(partnerApplication.save(company));        
        return new ResponseEntity<>(companyResource, HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/individual", method = RequestMethod.POST)
    public ResponseEntity<Resource<Individual>> save(@RequestBody Individual individual) {
        Resource<Individual> individualResource = new Resource<>(partnerApplication.save(individual));        
        return new ResponseEntity<>(individualResource, HttpStatus.CREATED);
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

}