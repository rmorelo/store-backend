package br.com.store.backend.application.partner;

import java.util.Collection;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.store.backend.domain.service.location.PostalAreaService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.District;
import br.com.store.backend.view.resource.partner.PostalArea;

@Service
public class PostalAreaApplicationImpl implements PostalAreaApplication {

	@Autowired
    private PostalAreaService postalAreaService;
	
    @Override
    @Profiled(level = Profiling.APPLICATION)    
	public PostalArea findByCodPostalArea(String codPostalArea, String selector){
    	PostalArea postalArea = postalAreaService.findByCodPostalArea(codPostalArea);
    	addDistrict(postalArea, selector);
    	return postalArea;
	}
    
    private void addDistrict(PostalArea postalArea, String selector) {
    	if (selector != null && selector.equals(PostalArea.DISTRICS)){
    		Collection<District> districts = postalAreaService.findDistricts(postalArea.getIdPostalArea());
	    	postalArea.setDistricts(districts);
    	}
    }

}
