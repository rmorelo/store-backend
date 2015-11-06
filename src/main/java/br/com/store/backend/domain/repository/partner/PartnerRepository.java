package br.com.store.backend.domain.repository.partner;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.store.backend.domain.entity.PartnerEntity;

public interface PartnerRepository extends JpaRepository<PartnerEntity, Long>{

    PartnerEntity findByIdPartner(Integer idPartner);

}
