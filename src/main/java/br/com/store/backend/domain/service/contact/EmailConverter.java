package br.com.store.backend.domain.service.contact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpMethod;

import br.com.store.backend.domain.entity.contact.EmailEntity;
import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.view.resource.contact.Email;
import br.com.store.backend.view.resource.partner.PartnerLinks;

public class EmailConverter {

    private static final String URI_PATTERN = "api/emails/";

    private EmailConverter() {
    }

    public static Email convert(EmailEntity emailEntity) {
        if (emailEntity == null) {
        	return null;
        }
        Email email = new Email();
        BeanUtils.copyProperties(emailEntity, email);
        createURI(email);
        createLinks(email);        

        return email;
    }
    
    public static EmailEntity convert(Email email) {
        if (email == null) {
        	return null;
        }
        EmailEntity emailEntity = new EmailEntity();
        BeanUtils.copyProperties(email, emailEntity);
        
        return emailEntity;
    }

    private static void createLinks(Email email) {

        List<Link> linkList = new ArrayList<Link>();
        for (PartnerLinks userLink : PartnerLinks.values()) {
            Link link = new Link(userLink.getDescription(), email.getUri() + userLink.getDescription(), HttpMethod.GET.name());
            linkList.add(link);
        }

        email.setLinks(linkList);
    }

    private static void createURI(Email email) {
        email.setUri(URI_PATTERN);
    }
    
}
