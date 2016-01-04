package br.com.store.backend.domain.service.location;

import br.com.store.backend.view.resource.location.PostalArea;

public interface PostalAreaService {
	
    PostalArea findPostalAreaByCodPostalArea(String codPostalArea);
    
    PostalArea findPostalArea(Integer idPostalArea);
    
}
