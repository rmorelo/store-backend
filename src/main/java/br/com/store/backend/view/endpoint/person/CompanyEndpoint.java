package br.com.store.backend.view.endpoint.person;

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

import br.com.store.backend.application.person.CompanyApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.view.resource.person.Company;

@RestController
public class CompanyEndpoint {

	@Autowired
    private CompanyApplication companyApplication;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/companies", method = RequestMethod.GET)
    public ResponseEntity<Resource<Company>> findCompanyByPartner(
    		@PathVariable(value = "idPartner") Integer idPartner) {
    	Company company = companyApplication.findCompanyByPartner(idPartner);
    	return new ResponseEntity<>(new Resource<Company>(company), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/partners/{idPartner}/companies", method = RequestMethod.POST)
    public ResponseEntity<Resource<Company>> saveCompanyOfPartner(@PathVariable(value = "idPartner") Integer idPartner, 
    		@RequestBody Company company) {
        Resource<Company> companyResource = new Resource<>(companyApplication.saveCompanyOfPartner(idPartner, company));        
        return new ResponseEntity<>(companyResource, HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/companies/{idCompany}", method = RequestMethod.PUT)
    public ResponseEntity<Resource<Company>> update(@PathVariable(value = "idCompany") Integer idCompany,
            @Validated @RequestBody Company company) {
    	company.setIdCompany(idCompany);
        Resource<Company> companyResource = new Resource<>(companyApplication.update(company));
        return new ResponseEntity<>(companyResource, HttpStatus.OK);
    }
        
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/companies/{idCompany}", method = RequestMethod.PATCH)
    public ResponseEntity<Resource<Company>> updatePartial(@PathVariable(value = "idCompany") Integer idCompany,
            @Validated @RequestBody Company company) {
    	company.setIdCompany(idCompany);
        Resource<Company> companyResource = new Resource<>(companyApplication.update(company));
        return new ResponseEntity<>(companyResource, HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/companies/{idCompany}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource<Company>> delete(@PathVariable(value = "idCompany") Integer idCompany){
    	companyApplication.delete(idCompany);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}