package br.com.store.backend.domain.service.location;

import br.com.store.backend.view.resource.partner.City;
import br.com.store.backend.view.resource.partner.FederationUnit;

public interface CityService {
	
    City find(Integer idCity);
    
    FederationUnit findFederationUnit(Integer idCity);
  
}
