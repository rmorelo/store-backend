package br.com.store.domain.repository.partner;

import br.com.store.domain.entity.PartnerEntity;
import br.com.store.infrastructure.rest.RestClientException;

public interface PartnerRepository {

    String SCHEME = "https";
    String HOST = "core.cubus.intranet";
    int PORT = 443;

    PartnerEntity getPartner(String name) throws RestClientException;

    PartnerEntity getPartner(Long idPartner) throws RestClientException;

}
