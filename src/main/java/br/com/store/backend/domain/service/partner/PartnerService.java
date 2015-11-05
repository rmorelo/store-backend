package br.com.store.backend.domain.service.partner;

import br.com.store.backend.infrastructure.rest.RestClientException;
import br.com.store.backend.view.resource.partner.Partner;

public interface PartnerService {
  
    Partner getPartner(Long idPartner) throws RestClientException;
}
