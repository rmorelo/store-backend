package br.com.store.backend.domain.repository.pet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.store.backend.domain.entity.customer.CustomerEntity;
import br.com.store.backend.domain.entity.pet.AnimalEntity;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer>{
    
    Page<AnimalEntity> findAllByCustomer(CustomerEntity customer, Pageable pageable);
    
}
