package br.com.store.backend.application.location;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.store.backend.domain.service.location.CountryService;
import br.com.store.backend.domain.service.location.FederationUnitService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.location.Country;

@Service
public class CountryApplicationImpl implements CountryApplication {
    
	@Autowired
    private FederationUnitService federationUnitService;
	
	@Autowired
    private CountryService countryService;
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public Country findCountryByFederationUnit(Integer idFederationUnit){
	    Country country = federationUnitService.findCountryByFederationUnit(idFederationUnit);
	    return country;
    }
	
    @Override
    @Profiled(level = Profiling.APPLICATION)
	public Country findCountry(Integer idCountry){
        Country country = countryService.findCountry(idCountry);        
		return country;
	}
 
}