package br.com.store.backend.domain.service.partner;

import org.springframework.beans.BeanUtils;
import br.com.store.backend.domain.entity.partner.PartnerEntity;
import br.com.store.backend.view.resource.partner.Partner;

public class PartnerConverter {

    private PartnerConverter() {
    }

    public static Partner convert(PartnerEntity entity) {
        if (entity == null) {
        	return null;
        }
        Partner partner = new Partner();
        BeanUtils.copyProperties(entity, partner);

        return partner;
    }
    
    public static PartnerEntity convert(Partner partner) {
        if (partner == null) {
        	return null;
        }
        PartnerEntity entity = new PartnerEntity();
        BeanUtils.copyProperties(partner, entity);
        
        return entity;
    }
    
}
