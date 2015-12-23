package br.com.store.backend.view.endpoint.location;

import javax.ws.rs.core.MediaType;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.store.backend.application.location.CountryApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.view.resource.location.Country;

@RestController
public class CountryEndpoint {
	
    @Autowired
    private CountryApplication countryApplication;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/federation-units/{idFederationUnit}/countries", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<Country>> findCountryByFederationUnit(@PathVariable(value = "idFederationUnit") Integer idFederationUnit) {
        Country country = countryApplication.findCountryByFederationUnit(idFederationUnit);
        return new ResponseEntity<>(new Resource<Country>(country), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/countries/{idCountry}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<Country>> findCountry(@PathVariable(value = "idCountry") Integer idCountry) {
        Country country = countryApplication.findCountry(idCountry);
        return new ResponseEntity<>(new Resource<Country>(country), HttpStatus.OK);
    }
}