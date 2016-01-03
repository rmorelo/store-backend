package br.com.store.backend.domain.service.location;

import org.springframework.beans.BeanUtils;

import br.com.store.backend.domain.entity.location.AddressEntity;
import br.com.store.backend.view.resource.location.Address;

public class AddressConverter {
       
    private AddressConverter() {
    }

    public static Address convert(AddressEntity addressEntity) {
        if (addressEntity == null) {
        	return null;
        }
        Address address = new Address();
        BeanUtils.copyProperties(addressEntity, address);
        
        return address;
    }
    
    public static AddressEntity convert(Address address) {
        if (address == null) {
        	return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        BeanUtils.copyProperties(address, addressEntity);
        
        return addressEntity;
    }
    
}
