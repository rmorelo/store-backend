package br.com.store.backend.domain.service.contact;

import org.springframework.beans.BeanUtils;
import br.com.store.backend.domain.entity.contact.TelephoneEntity;
import br.com.store.backend.view.resource.contact.Telephone;

public class TelephoneConverter {

    private TelephoneConverter() {
    }

    public static Telephone convert(TelephoneEntity telephoneEntity) {
        if (telephoneEntity == null) {
        	return null;
        }
        Telephone telephone = new Telephone();
        BeanUtils.copyProperties(telephoneEntity, telephone);

        return telephone;
    }
    
    public static TelephoneEntity convert(Telephone telephone) {
        if (telephone == null) {
        	return null;
        }
        TelephoneEntity telephoneEntity = new TelephoneEntity();
        BeanUtils.copyProperties(telephone, telephoneEntity);
        
        return telephoneEntity;
    }
   
}
