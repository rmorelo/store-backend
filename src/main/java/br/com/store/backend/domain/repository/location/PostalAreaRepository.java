package br.com.store.backend.domain.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.store.backend.domain.entity.location.PostalAreaEntity;

public interface PostalAreaRepository extends JpaRepository<PostalAreaEntity, Integer>{
   
    PostalAreaEntity findByCodPostalArea(String codPostalArea);
    
}
