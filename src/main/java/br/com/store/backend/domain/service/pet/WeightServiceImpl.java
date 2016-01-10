package br.com.store.backend.domain.service.pet;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.pet.AnimalEntity;
import br.com.store.backend.domain.entity.pet.WeightEntity;
import br.com.store.backend.domain.repository.pet.AnimalRepository;
import br.com.store.backend.domain.repository.pet.WeightRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.pet.Weight;

@Service
@Transactional(readOnly = true)
public class WeightServiceImpl implements WeightService {

    @Autowired
    private WeightRepository weightRepository;
    
    @Autowired
    private AnimalRepository animalRepository;
    
    @Resource
	private WeightServiceMapper weightServiceMapper;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Weight findWeight(Integer idWeight) {
        WeightEntity weightEntity = weightRepository.findOne(idWeight);
    	
    	if(weightEntity == null){
    		throw new NotFoundException(NotFoundException.WEIGHT_NOT_FOUND);
    	}
    	
    	return WeightConverter.convert(weightEntity);
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Collection<Weight> findWeights() {
    	Collection<WeightEntity> weightEntities = weightRepository.findAll();
    	
    	if(weightEntities == null || weightEntities.isEmpty()){
    		throw new NotFoundException(NotFoundException.WEIGHT_NOT_FOUND);
    	}
        
        Collection<Weight> weights = new ArrayList<Weight>();

        for (WeightEntity weightEntity : weightEntities){
            Weight weight = WeightConverter.convert(weightEntity);
            weights.add(weight);
        }
        
        return weights;
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Weight findWeightByAnimal(Integer idAnimal){
    	AnimalEntity animalEntity = animalRepository.findOne(idAnimal);
    	
    	if(animalEntity == null){
    		throw new NotFoundException(NotFoundException.ANIMAL_NOT_FOUND);
    	}
    	
    	WeightEntity weightEntity = animalEntity.getWeight();
     	
     	if(weightEntity == null){
     		throw new NotFoundException(NotFoundException.WEIGHT_NOT_FOUND);
     	}
     	
     	return WeightConverter.convert(weightEntity);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Weight saveWeight(Weight weight) {
    	WeightEntity weightEntity = WeightConverter.convert(weight);       
    	weightEntity = weightRepository.save(weightEntity);
        return WeightConverter.convert(weightEntity);
	}
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public Weight update(Weight weight) {    	
    	WeightEntity weightEntity = weightRepository.findOne(weight.getIdWeight());
    	
    	if(weightEntity == null){
    		throw new NotFoundException(NotFoundException.WEIGHT_NOT_FOUND);
    	}
    	
    	weightServiceMapper.mapWeightToWeightEntity(weight, weightEntity);
    	WeightEntity weightEntitySaved = weightRepository.save(weightEntity);
        return WeightConverter.convert(weightEntitySaved);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public void delete(Integer idWeight) {
    	WeightEntity weightEntity = weightRepository.findOne(idWeight);
    	
    	if(weightEntity == null){
    		throw new NotFoundException(NotFoundException.WEIGHT_NOT_FOUND);
    	}
    	
        weightRepository.delete(weightEntity.getIdWeight());        
    }
    
}
