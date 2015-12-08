package br.com.store.backend.domain.service.location;

import br.com.store.backend.view.resource.partner.PostalArea;

public interface PostalAreaService {
	
    PostalArea findByCodPostalArea(String codPostalArea);
  
}
