package br.com.store.backend.application.location;

import br.com.store.backend.view.resource.location.Country;

public interface CountryApplication {
 	
    Country findCountryByFederationUnit(Integer idFederationUnit);
    
    Country findCountry(Integer idCountry);
	
}
