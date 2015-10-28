package br.com.store.domain.service.partner;

import br.com.store.infrastructure.rest.RestClientException;
import br.com.store.view.resource.partner.Partner;

public interface PartnerService {

    String SCHEME = "https";
    String HOST = "core.cubus.intranet";
    int PORT = 443;

    
    Partner getPartner(String login) throws RestClientException;
    
    Partner getPartner(Long idPartner) throws RestClientException;
}
