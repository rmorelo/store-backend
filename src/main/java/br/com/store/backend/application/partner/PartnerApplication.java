package br.com.store.backend.application.partner;

import br.com.store.backend.view.resource.partner.Partner;

public interface PartnerApplication {
    
    Partner findByIdPartner(Integer idPartner);
    
    Partner save(Partner partner);
    
    Partner update(Partner partner);

}
