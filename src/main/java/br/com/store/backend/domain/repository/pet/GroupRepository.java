package br.com.store.backend.domain.repository.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.store.backend.domain.entity.pet.GroupEntity;

public interface GroupRepository extends JpaRepository<GroupEntity, Integer>{
    
}
