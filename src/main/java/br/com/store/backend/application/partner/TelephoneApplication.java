package br.com.store.backend.application.partner;

import br.com.store.backend.view.resource.partner.Telephone;

public interface TelephoneApplication {
 
	Telephone save(Integer idPartner, Telephone telephone);
	
}
