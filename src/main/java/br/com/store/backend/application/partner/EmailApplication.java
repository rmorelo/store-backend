package br.com.store.backend.application.partner;

import br.com.store.backend.view.resource.partner.Email;

public interface EmailApplication {
 
	Email save(Integer idPartner, Email email);
	
}
