package br.com.store.backend.domain.service.location;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import br.com.store.backend.domain.entity.DistrictEntity;
import br.com.store.backend.domain.entity.PostalAreaEntity;
import br.com.store.backend.view.resource.partner.District;
import br.com.store.backend.view.resource.partner.PostalArea;

public class PostalAreaConverter {

    private PostalAreaConverter() {
    }

    public static PostalArea convert(PostalAreaEntity postalAreaEntity) {
        if (postalAreaEntity == null) {
        	return null;
        }
        PostalArea postalArea = new PostalArea();
        BeanUtils.copyProperties(postalAreaEntity, postalArea);
        addObjectFields(postalAreaEntity, postalArea);
        
        return postalArea;
    }
    
    public static PostalAreaEntity convert(PostalArea postalArea) {
        if (postalArea == null) {
        	return null;
        }
        PostalAreaEntity postalAreaEntity = new PostalAreaEntity();
        BeanUtils.copyProperties(postalArea, postalAreaEntity);
        
        return postalAreaEntity;
    }
    
    
    private static void addObjectFields(PostalAreaEntity postalAreaEntity, PostalArea postalArea) {
        if(postalAreaEntity.getDistrict() != null){
        	List<District> districts = new ArrayList<District>();
        	for(DistrictEntity districtEntity : postalAreaEntity.getDistrict()){
        		District districtResult = new District();
        		District district = DistrictConverter.convert(districtEntity);
        		districtResult.setIdDistrict(district.getIdDistrict());
        		districts.add(districtResult);
        	}
        	postalArea.setDistricts(districts);
        }
    }
    
}
