package br.com.store.backend.application.location;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.store.backend.domain.service.location.CityService;
import br.com.store.backend.domain.service.location.FederationUnitService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.location.Country;
import br.com.store.backend.view.resource.location.FederationUnit;

@Service
public class FederationUnitApplicationImpl implements FederationUnitApplication {
    
	@Autowired
	private CityService cityService;
	
	@Autowired
    private FederationUnitService federationUnitService;
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public FederationUnit findFederationUnitByCity(Integer idCity, String selector){
	    FederationUnit federationUnit = cityService.findFederationUnitByCity(idCity);
	    addCountry(federationUnit, selector);
        return federationUnit;
    }
	
    @Override
    @Profiled(level = Profiling.APPLICATION)
	public FederationUnit findFederationUnit(Integer idFederationUnit, String selector){
        FederationUnit federationUnit = federationUnitService.findFederationUnit(idFederationUnit);
        addCountry(federationUnit, selector);
		return federationUnit;
	}
    
    private void addCountry(FederationUnit federationUnit, String selector) {
    	if (selector != null && selector.equals(FederationUnit.COUNTRIES)){
    	    Country country = federationUnitService.findCountryByFederationUnit(federationUnit.getIdFederationUnit());
    	    federationUnit.setCountry(country);
    	}
    }
}