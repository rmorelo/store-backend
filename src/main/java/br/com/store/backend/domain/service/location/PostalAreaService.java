package br.com.store.backend.domain.service.location;

import java.util.Collection;

import br.com.store.backend.view.resource.partner.District;
import br.com.store.backend.view.resource.partner.PostalArea;

public interface PostalAreaService {
	
    PostalArea findByCodPostalArea(String codPostalArea);
  
    Collection<District> findDistricts(Integer idPostalArea);

    
}
