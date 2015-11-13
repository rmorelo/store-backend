package br.com.store.backend.domain.service.partner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpMethod;

import br.com.store.backend.domain.entity.CompanyEntity;
import br.com.store.backend.domain.entity.PartnerEntity;
import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.view.resource.partner.Company;
import br.com.store.backend.view.resource.partner.Partner;
import br.com.store.backend.view.resource.partner.PartnerLinks;

public class CompanyConverter {

    private static final String URI_PATTERN = "api/partners/company";

    private CompanyConverter() {
    }

    public static Company convert(CompanyEntity entity) {
        if (entity == null) {
        	return null;
        }
        Company company = new Company();
        BeanUtils.copyProperties(entity, company);
        createURI(company);
        createLinks(company);
        addObjectFields(entity, company);

        return company;
    }
    
    public static CompanyEntity convert(Company company) {
        if (company == null) {
        	return null;
        }
        CompanyEntity entity = new CompanyEntity();
        BeanUtils.copyProperties(company, entity);
        
        return entity;
    }

    private static void createLinks(Company company) {

        List<Link> linkList = new ArrayList<Link>();
        for (PartnerLinks userLink : PartnerLinks.values()) {
            Link link = new Link(userLink.getDescription(), company.getUri() + userLink.getDescription(), HttpMethod.GET.name());
            linkList.add(link);
        }

        company.setLinks(linkList);
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
