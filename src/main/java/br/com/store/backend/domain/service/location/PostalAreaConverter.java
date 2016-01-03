package br.com.store.backend.domain.service.location;

import org.springframework.beans.BeanUtils;
import br.com.store.backend.domain.entity.location.PostalAreaEntity;
import br.com.store.backend.view.resource.location.PostalArea;

public class PostalAreaConverter {
       
    private PostalAreaConverter() {
    }

    public static PostalArea convert(PostalAreaEntity postalAreaEntity) {
        if (postalAreaEntity == null) {
        	return null;
        }
        PostalArea postalArea = new PostalArea();
        BeanUtils.copyProperties(postalAreaEntity, postalArea, "districts");
        
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
    
}
