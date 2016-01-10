package br.com.store.backend.application.contact;

import br.com.store.backend.view.resource.contact.Email;

public interface EmailApplication {
 
	Email saveEmailOfPartner(Integer idPartner, Email email);
	
	Email saveEmailOfCustomer(Integer idCustomer, Email email);

	Email findEmailByCustomer(Integer idCustomer);
	
	Email findEmailByPartner(Integer idPartner);
	
}
