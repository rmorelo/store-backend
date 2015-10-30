package br.com.store.backend.domain.repository.partner;

import br.com.store.backend.domain.entity.PartnerEntity;
import br.com.store.backend.infrastructure.rest.RestClientException;
import br.com.uol.cubus.support.domain.entity.question.SecurityUserQuestionEntity;
import br.com.uol.cubus.support.domain.repository.question.JpaRepository;

public interface PartnerRepository extends JpaRepository<SecurityUserQuestionEntity, Long>{

    String SCHEME = "http";
    String HOST = "store.backend.intranet";
    int PORT = 443;

    PartnerEntity getPartner(Long idPartner) throws RestClientException;

}
