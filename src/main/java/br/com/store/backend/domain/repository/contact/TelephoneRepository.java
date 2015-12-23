package br.com.store.backend.domain.repository.contact;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.store.backend.domain.entity.contact.TelephoneEntity;

public interface TelephoneRepository extends JpaRepository<TelephoneEntity, Integer>{
   
}
