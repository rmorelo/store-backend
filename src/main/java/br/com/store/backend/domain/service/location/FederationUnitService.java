package br.com.store.backend.domain.service.location;

import br.com.store.backend.view.resource.location.Country;
import br.com.store.backend.view.resource.location.FederationUnit;

public interface FederationUnitService {
	
    FederationUnit findFederationUnit(Integer idFederationUnit);
    
    Country findCountryByFederationUnit(Integer idFederationUnit);
  
}
