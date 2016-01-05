package br.com.store.backend.domain.repository.customer;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.store.backend.domain.entity.customer.CustomerEntity;
import br.com.store.backend.domain.entity.partner.PartnerEntity;


public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{
    
    Page<CustomerEntity> findAllByPartners(PartnerEntity partner, Pageable pageable);
    
}
