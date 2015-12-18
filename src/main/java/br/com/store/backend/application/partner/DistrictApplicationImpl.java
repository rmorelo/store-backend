package br.com.store.backend.application.partner;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.location.CityService;
import br.com.store.backend.domain.service.location.DistrictService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.City;
import br.com.store.backend.view.resource.partner.District;

@Service
public class DistrictApplicationImpl implements DistrictApplication {

	@Autowired
	private CityService cityService;
    
	@Autowired
	private DistrictService districtService;
	
    @Override
    @Profiled(level = Profiling.APPLICATION)    
	public District findCityByIdDistrict(Integer idDistrict){
    	District district = districtService.find(idDistrict);
    	addCity(district);
    	return district;
	}
    
    private void addCity(District district) {
    	if(district != null){
    		City city = cityService.find(district.getCity().getIdCity());
    		district.setCity(city);
    	}
    }

}
