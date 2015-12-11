package br.com.store.backend.domain.repository.partner;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.store.backend.domain.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Integer>{
    
}
