package br.com.store.backend.domain.repository.partner;

import java.util.Collection;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.store.backend.domain.entity.customer.CustomerEntity;
import br.com.store.backend.domain.entity.partner.PartnerEntity;

public interface PartnerRepository extends JpaRepository<PartnerEntity, Integer>{

    Collection<PartnerEntity> findAllByCustomer(CustomerEntity customer, Pageable pageable);
    
}
