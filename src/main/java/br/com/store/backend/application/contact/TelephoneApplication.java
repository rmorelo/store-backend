package br.com.store.backend.application.contact;

import br.com.store.backend.view.resource.contact.Telephone;

public interface TelephoneApplication {
 
	Telephone save(Integer idPartner, Telephone telephone);
	
}
