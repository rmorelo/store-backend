package br.com.store.backend.application.location;

import java.util.Collection;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.location.PostalAreaService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.location.District;
import br.com.store.backend.view.resource.location.PostalArea;

@Service
public class PostalAreaApplicationImpl implements PostalAreaApplication {

	@Autowired
    private PostalAreaService postalAreaService;
	
    @Override
    @Profiled(level = Profiling.APPLICATION)    
	public PostalArea findPostalAreaByCodPostalArea(String codPostalArea, String selector){
    	PostalArea postalArea = postalAreaService.findPostalAreaByCodPostalArea(codPostalArea);
    	addDistrict(postalArea, selector);
    	return postalArea;
	}
    
    @Override
    @Profiled(level = Profiling.APPLICATION)    
	public PostalArea findPostalArea(Integer idPostalArea, String selector){
    	PostalArea postalArea = postalAreaService.findPostalArea(idPostalArea);
    	addDistrict(postalArea, selector);
    	return postalArea;
	}
    
    private void addDistrict(PostalArea postalArea, String selector) {
    	if (selector != null && selector.equals(PostalArea.DISTRICS)){
    		Collection<District> districts = postalAreaService.findDistrictsByPostalArea(postalArea.getIdPostalArea());
	    	postalArea.setDistricts(districts);
    	}
    }

}
