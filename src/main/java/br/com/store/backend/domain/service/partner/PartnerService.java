package br.com.store.backend.domain.service.partner;

import br.com.store.backend.infrastructure.rest.RestClientException;
import br.com.store.backend.view.resource.partner.Partner;

public interface PartnerService {

    String SCHEME = "http";
    String HOST = "store.backend.intranet";
    int PORT = 443;
  
    Partner getPartner(Long idPartner) throws RestClientException;
}
