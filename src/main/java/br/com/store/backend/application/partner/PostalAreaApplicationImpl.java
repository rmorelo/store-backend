package br.com.store.backend.application.partner;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.location.CityService;
import br.com.store.backend.domain.service.location.DistrictService;
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
    
	@Autowired
	private DistrictService districtService;
	
    @Override
    @Profiled(level = Profiling.APPLICATION)    
	public PostalArea findByCodPostalArea(String codPostalArea, String[] selector){
    	
    	PostalArea postalArea = postalAreaService.findByCodPostalArea(codPostalArea);
    	
    	boolean hasDistrictSelector = ArrayUtils.contains(selector, PostalArea.DISTRICS);
    	if (hasDistrictSelector) {
    		addDistrict(postalArea);
    		
    		boolean hasCitySelector = ArrayUtils.contains(selector, PostalArea.CITY);
        	if (hasCitySelector) {
        		addCity(postalArea);
            }
        }
    	
    	
    	
        return postalArea;
	}
    
    private void addDistrict(PostalArea postalArea) {
    	List<District> districts = new ArrayList<District>();
    	
    	for (District district : postalArea.getDistricts()){
    		if(district != null){
    			District districtResult = districtService.find(district.getIdDistrict());
    			districts.add(districtResult);
    		}
    	}
    	postalArea.setDistricts(districts);
    }
    
    private void addCity(PostalArea postalArea) {
    	List<District> districts = new ArrayList<District>();

    	for (District district : postalArea.getDistricts()){
    		if(district != null){
    			City city = cityService.find(district.getCity().getIdCity());
    			district.setCity(city);
    			districts.add(district);
    			
    		}
    	}
    	
    }

}
