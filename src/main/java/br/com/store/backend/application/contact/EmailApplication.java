package br.com.store.backend.application.contact;

import br.com.store.backend.view.resource.contact.Email;

public interface EmailApplication {
 
	Email save(Integer idPartner, Email email);
	
}
