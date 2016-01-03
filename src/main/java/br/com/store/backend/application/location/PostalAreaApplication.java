package br.com.store.backend.application.location;

import br.com.store.backend.view.resource.location.PostalArea;

public interface PostalAreaApplication {
 
    PostalArea findPostalAreaByCodPostalArea(String codPostalArea, String selector);
    
    PostalArea findPostalArea(Integer idPostalArea, String selector);
	
}
