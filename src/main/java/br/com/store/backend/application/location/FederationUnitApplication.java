package br.com.store.backend.application.location;

import br.com.store.backend.view.resource.location.FederationUnit;

public interface FederationUnitApplication {
 	
    FederationUnit findFederationUnitByCity(Integer idCity, String selector);
    
    FederationUnit findFederationUnit(Integer idFederationUnit, String selector);
	
}
