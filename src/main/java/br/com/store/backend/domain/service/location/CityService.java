package br.com.store.backend.domain.service.location;

import br.com.store.backend.view.resource.location.City;
import br.com.store.backend.view.resource.location.FederationUnit;

public interface CityService {
	
    City findCity(Integer idCity);
    
    FederationUnit findFederationUnitByCity(Integer idCity);
  
}
