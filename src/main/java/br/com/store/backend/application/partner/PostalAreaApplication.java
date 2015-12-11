package br.com.store.backend.application.partner;

import br.com.store.backend.view.resource.partner.PostalArea;

public interface PostalAreaApplication {
 
    PostalArea findByCodPostalArea(String codPostalArea, String[] selector);
	
}
