package br.com.store.backend.domain.service.partner;

import br.com.store.backend.view.resource.partner.Partner;

public interface PartnerService {
  
    Partner findByIdPartner(Integer idPartner);
    
    Partner savePartner(Partner partner);
}
