package br.com.store.backend.domain.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.store.backend.domain.entity.location.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer>{
    
}
