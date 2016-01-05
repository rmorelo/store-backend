package br.com.store.backend.domain.repository.location;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.store.backend.domain.entity.location.DistrictEntity;
import br.com.store.backend.domain.entity.location.PostalAreaEntity;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Integer>{
    
    List<DistrictEntity> findAllByPostalAreas(PostalAreaEntity postalAreaEntity);
	
}
