package br.com.store.backend.application.location;

import br.com.store.backend.view.resource.location.PostalArea;

public interface PostalAreaApplication {
 
    PostalArea findByCodPostalArea(String codPostalArea, String selector);
	
}
