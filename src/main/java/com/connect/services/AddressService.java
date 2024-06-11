
package com.connect.services;

import com.connect.entities.Address;
import com.connect.entities.Resident;
import com.connect.repositories.AddressRepository;
import exception.MiException;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepo;
    
    
    @Transactional
    public Address createAddress(Address address) {
        
        return addressRepo.save(address);
        
    }
    
    @Transactional
    public Address updateAddress(Address address) {
        
        return addressRepo.save(address);
        
    }
    
    public void deleteAddress(String id){
        addressRepo.deleteById(id);
    }
    
    public Address searchAddressById(String id){
         Optional<Address> response = addressRepo.findById(id);
        
        if(response.isPresent()){
            return response.get();
        }
        return null;
    }
   
}
