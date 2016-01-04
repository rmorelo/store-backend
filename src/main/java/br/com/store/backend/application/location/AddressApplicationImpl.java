package br.com.store.backend.application.location;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.location.AddressService;
import br.com.store.backend.domain.service.location.PostalAreaService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.location.Address;
import br.com.store.backend.view.resource.location.PostalArea;

@Service
public class AddressApplicationImpl implements AddressApplication {

	@Autowired
    private AddressService addressService;
	
	@Autowired
	private PostalAreaService postalAreaService;
	
    @Override
    @Profiled(level = Profiling.APPLICATION)    
	public Address findAddress(Integer idAddress, String selector){
    	Address address = addressService.findAddress(idAddress);
    	addPostalArea(address, selector);
    	return address;
	}
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Address saveAddressOfPartner(Integer idPartner, Address address){
    	return addressService.saveAddressOfPartner(idPartner, address);
    }

    
    @Override
    @Profiled(level = Profiling.APPLICATION)    
	public Address save(Address address){
    	PostalArea postalArea = postalAreaService.findPostalArea(address.getPostalArea().getIdPostalArea());
    	address.setPostalArea(postalArea);
    	Address addressResource = addressService.save(address);
    	return addressResource;
    }
    
    private void addPostalArea(Address address, String selector) {
    	if (selector != null && selector.equals(Address.POSTALAREAS)){
    		PostalArea postalArea = addressService.findPostalAreaByAddress(address.getIdAddress());
    		address.setPostalArea(postalArea);
    	}
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)    
	public Address update(Address address){
    	Address addressResource = addressService.update(address);
    	return addressResource;
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)    
	public void delete(Integer idAddress){
    	addressService.delete(idAddress);
    }

}
