package br.com.store.backend.domain.repository.location;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.store.backend.domain.entity.location.DistrictEntity;
import br.com.store.backend.domain.entity.location.PostalAreaEntity;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Integer>{
    
    Collection<DistrictEntity> findAllByPostalArea(PostalAreaEntity postalAreaEntity);
	
}
