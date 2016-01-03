package br.com.store.backend.application.partner;

import br.com.store.backend.view.resource.partner.Partner;

public interface PartnerApplication {
    
    Partner findPartner(Integer idPartner, String selector);
    
    Partner save(Partner partner);
    
    Partner update(Partner partner);

    Partner updateAddress(Integer idPartner, Integer idAddress);
    
    void delete(Integer idPartner);
    
}
