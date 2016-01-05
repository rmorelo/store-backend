package br.com.store.backend.domain.repository.partner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.store.backend.domain.entity.customer.CustomerEntity;
import br.com.store.backend.domain.entity.partner.PartnerEntity;

public interface PartnerRepository extends JpaRepository<PartnerEntity, Integer>{

    Page<PartnerEntity> findAllByCustomers(CustomerEntity customerEntity, Pageable pageable);
    
}
