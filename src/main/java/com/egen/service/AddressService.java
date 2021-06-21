package com.egen.service;


import com.egen.model.Address;
import com.egen.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressService {


    @Autowired
    AddressRepository repo;
    public List<Address> findAll() {
        List<Address> list = (List<Address>) repo.findAll();

        return list;
    }

    public Address getById(long id) {
        Optional<Address> existing = repo.findById(id);

        Address val=existing.get();
        return val;
    }

    public Address create(Address add) {
        Optional<Address> existing = repo.findById(add.getId());

        return repo.save(add);
    }


    public Address update(Address add) {
        Optional<Address> existing = repo.findById(add.getId());

        return repo.save(add);
    }

    public void delete(long id){
            Optional<Address> existing = repo.findById(id);

            repo.deleteById(id);
    }
}
