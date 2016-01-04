package br.com.store.backend.domain.service.location;

import java.util.Date;

import javax.annotation.Resource;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.customer.CustomerEntity;
import br.com.store.backend.domain.entity.location.AddressEntity;
import br.com.store.backend.domain.entity.location.PostalAreaEntity;
import br.com.store.backend.domain.entity.partner.PartnerEntity;
import br.com.store.backend.domain.repository.customer.CustomerRepository;
import br.com.store.backend.domain.repository.location.AddressRepository;
import br.com.store.backend.domain.repository.partner.PartnerRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.location.Address;
import br.com.store.backend.view.resource.location.PostalArea;

@Service
@Transactional(readOnly = true)
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    
    @Resource
	private AddressServiceMapper addressServiceMapper;
    
    @Autowired
    private PartnerRepository partnerRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Address findAddress(Integer idAddress) {
    	AddressEntity addressEntity = addressRepository.findOne(idAddress);
                
        if(addressEntity == null){
            throw new NotFoundException(NotFoundException.ADDRESS_NOT_FOUND);
        }
        
        Address address = AddressConverter.convert(addressEntity);
        
        return address;
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public PostalArea findPostalAreaByAddress(Integer idAddress){
    	AddressEntity addressEntity = addressRepository.findOne(idAddress);
        
        if(addressEntity == null){
            throw new NotFoundException(NotFoundException.ADDRESS_NOT_FOUND);
        }
        
        PostalAreaEntity postalAreaEntity = addressEntity.getPostalArea();
        
        if(postalAreaEntity == null){
            throw new NotFoundException(NotFoundException.POSTAL_AREA_NOT_FOUND);
        }
        
        PostalArea postalArea = PostalAreaConverter.convert(postalAreaEntity);
        
        return postalArea;
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Address save(Address address) {
    	address.setSignupDate(new Date());
        AddressEntity addressEntity = AddressConverter.convert(address);       
        addressEntity = addressRepository.save(addressEntity);
        return AddressConverter.convert(addressEntity);
	}
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Address update(Address address) {
    	address.setSignupDate(new Date());
    	AddressEntity addressEntity = addressRepository.findOne(address.getIdAddress());
    	
    	if(addressEntity == null){
            throw new NotFoundException(NotFoundException.ADDRESS_NOT_FOUND);
        }
    	
    	addressServiceMapper.mapAddressToAddressEntity(address, addressEntity);
    	addressEntity = addressRepository.save(addressEntity);
    	return AddressConverter.convert(addressEntity);
	}
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public void delete(Integer idAddress) {
    	AddressEntity addressEntity = addressRepository.findOne(idAddress);

    	if(addressEntity == null){
            throw new NotFoundException(NotFoundException.ADDRESS_NOT_FOUND);
        }
    	
    	addressRepository.delete(addressEntity);
	}
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Address findAddressByPartner(Integer idPartner){
    	PartnerEntity partnerEntity = partnerRepository.findOne(idPartner);
    	
    	if(partnerEntity == null){
    		throw new NotFoundException(NotFoundException.PARTNER_NOT_FOUND);
    	}
    	
    	AddressEntity addressEntity = partnerEntity.getAddress();

    	if(addressEntity == null){
            throw new NotFoundException(NotFoundException.ADDRESS_NOT_FOUND);
        }
    	
    	return AddressConverter.convert(addressEntity);
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Address findAddressByCustomer(Integer idCustomer){
        CustomerEntity customerEntity = customerRepository.findOne(idCustomer);
        
        if(customerEntity == null){
            throw new NotFoundException(NotFoundException.CUSTOMER_NOT_FOUND);
        }
        
        AddressEntity addressEntity = customerEntity.getAddress();

        if(addressEntity == null){
            throw new NotFoundException(NotFoundException.ADDRESS_NOT_FOUND);
        }
        
        return AddressConverter.convert(addressEntity);
    }

}
