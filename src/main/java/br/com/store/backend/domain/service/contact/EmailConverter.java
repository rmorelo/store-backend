package br.com.store.backend.domain.service.contact;

import org.springframework.beans.BeanUtils;
import br.com.store.backend.domain.entity.contact.EmailEntity;
import br.com.store.backend.view.resource.contact.Email;

public class EmailConverter {

	private EmailConverter() {
    }

    public static Email convert(EmailEntity emailEntity) {
        if (emailEntity == null) {
        	return null;
        }
        Email email = new Email();
        BeanUtils.copyProperties(emailEntity, email);
    
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
   
}
