package br.com.store.backend.domain.repository.partner;

import br.com.store.backend.domain.entity.PartnerEntity;
import br.com.store.backend.infrastructure.rest.RestClientException;

public interface PartnerRepository {

    String SCHEME = "http";
    String HOST = "store.backend.intranet";
    int PORT = 443;

    PartnerEntity getPartner(Long idPartner) throws RestClientException;

}
