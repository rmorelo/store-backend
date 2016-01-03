package br.com.store.backend.domain.service.location;

import org.springframework.beans.BeanUtils;
import br.com.store.backend.domain.entity.location.DistrictEntity;
import br.com.store.backend.view.resource.location.District;

public class DistrictConverter {

    private DistrictConverter() {
    }

    public static District convert(DistrictEntity districtEntity) {
        if (districtEntity == null) {
        	return null;
        }
        District district = new District();
        BeanUtils.copyProperties(districtEntity, district);
     
        return district;
    }
    
    public static DistrictEntity convert(District district) {
        if (district == null) {
        	return null;
        }
        DistrictEntity districtEntity = new DistrictEntity();
        BeanUtils.copyProperties(district, districtEntity);
        
        return districtEntity;
    }
    
}
