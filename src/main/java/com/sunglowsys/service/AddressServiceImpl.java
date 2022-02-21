package com.sunglowsys.service;

import com.sunglowsys.domain.Address;
import com.sunglowsys.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService{

    private final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address address) {
        log.debug("Request to save Address: {}",address);
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        log.debug("Request to update Address: {}",address);
        return addressRepository.save(address);
    }

    @Override
    public Page<Address> findAll(Pageable pageable) {
        log.debug("Request to findAll Addresses: {}",pageable.toString());
        return addressRepository.findAll(pageable);
    }

    @Override
    public Optional<Address> findById(Long id) {
        log.debug("Request to findById Address: {}",id);
        return addressRepository.findById(id);
    }



    @Override
    public void delete(Long id) {
        log.debug("Request to delete Address: {}",id);
        addressRepository.deleteById(id);

    }
}
