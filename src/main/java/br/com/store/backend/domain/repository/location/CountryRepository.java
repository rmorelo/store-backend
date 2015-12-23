package br.com.store.backend.domain.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.store.backend.domain.entity.location.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer>{
    
}
