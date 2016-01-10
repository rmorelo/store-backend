package br.com.store.backend.domain.repository.pet;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.store.backend.domain.entity.customer.CustomerEntity;
import br.com.store.backend.domain.entity.pet.AnimalEntity;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer>{
    
    List<AnimalEntity> findAllByCustomer(CustomerEntity customer);
    
}
