package br.com.store.backend.domain.service.location;

import java.util.Collection;

import br.com.store.backend.view.resource.location.District;
import br.com.store.backend.view.resource.location.PostalArea;

public interface PostalAreaService {
	
    PostalArea findByCodPostalArea(String codPostalArea);
  
    Collection<District> findDistrictsByPostalArea(Integer idPostalArea);

    
}
