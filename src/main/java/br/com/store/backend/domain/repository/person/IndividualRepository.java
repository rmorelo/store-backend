package br.com.store.backend.domain.repository.person;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.store.backend.domain.entity.person.IndividualEntity;

public interface IndividualRepository extends JpaRepository<IndividualEntity, Integer>{

}
