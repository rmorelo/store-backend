package br.com.store.backend.application.partner;

import org.apache.commons.lang.ArrayUtils;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.location.CityService;
import br.com.store.backend.domain.service.location.PostalAreaService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.City;
import br.com.store.backend.view.resource.partner.District;
import br.com.store.backend.view.resource.partner.PostalArea;

@Service
public class PostalAreaApplicationImpl implements PostalAreaApplication {

	@Autowired
    private PostalAreaService postalAreaService;
	
	@Autowired
	private CityService cityService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)    
	public PostalArea findByCodPostalArea(String codPostalArea, String[] selector){
    	
    	PostalArea postalArea = postalAreaService.findByCodPostalArea(codPostalArea);
    	
    	boolean hasCitySelector = ArrayUtils.contains(selector, PostalArea.CITY);
    	if (hasCitySelector) {
    		addCity(postalArea);
        }
    	
        return postalArea;
	}
    
    private void addCity(PostalArea postalArea) {
    	for (District district : postalArea.getDistricts()){
    		if(district != null){
    			City city = cityService.find(district.getIdCity());	
    		}
    	}
    }

}
