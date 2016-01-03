package br.com.store.backend.domain.repository.person;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.store.backend.domain.entity.person.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{

}
