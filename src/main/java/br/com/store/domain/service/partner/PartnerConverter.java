package br.com.store.domain.service.partner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;

import br.com.store.domain.entity.PartnerEntity;
import br.com.store.infrastructure.rest.model.Link;
import br.com.store.view.resource.partner.Partner;
import br.com.store.view.resource.partner.PartnerLinks;

public class PartnerConverter {

    private static final String URI_PATTERN = "api/partners/";

    private PartnerConverter() {
    }

    public static Partner convert(PartnerEntity entity) {
        if (entity != null) {
            Partner partner = new Partner();
            partner.setId(entity.getId());
            partner.setName(entity.getName());
            
            createURI(partner);
            createLinks(partner);
            addObjectFields(entity, partner);

            return partner;
        } else {
            return null;
        }
    }

    public static PartnerEntity convert(Partner partner) {
    	PartnerEntity entity = new PartnerEntity();
        
    	entity.setId(partner.getId());
        
    	entity.setName(partner.getName());

        return entity;
    }

    private static void createLinks(Partner partner) {

        List<Link> linkList = new ArrayList<Link>();
        for (PartnerLinks userLink : PartnerLinks.values()) {
            Link link = new Link(userLink.getDescription(), partner.getUri() + userLink.getDescription(), HttpMethod.GET.name());
            linkList.add(link);
        }

        partner.setLinks(linkList);
    }

    private static void createURI(Partner partner) {
        partner.setUri(URI_PATTERN);
    }

    private static void addObjectFields(PartnerEntity entity, Partner partner) {
//        if (CollectionUtils.isNotEmpty(entity.getTrademarks())) {
//            user.setTrademark(TrademarkConverter.convert(entity.getUserTrademark()));
//        }
//        if (CollectionUtils.isNotEmpty(entity.getContacts())) {
//            user.setContacts(ContactConverter.convert(entity.getContacts()));
//        }
    }
    
}
