package br.com.store.backend.domain.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.store.backend.domain.entity.location.FederationUnitEntity;

public interface FederationUnitRepository extends JpaRepository<FederationUnitEntity, Integer>{
    
}
