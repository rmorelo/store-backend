package br.com.store.backend.domain.repository.partner;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.store.backend.domain.entity.partner.PartnerEntity;

public interface PartnerRepository extends JpaRepository<PartnerEntity, Integer>{

    PartnerEntity findByIdPartner(Integer idPartner);

}
