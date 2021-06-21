package com.egen.service;


import com.egen.model.Customer;
import com.egen.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepositoryImpl;

    public List<Customer> findAll(){
        List<Customer> list = (List<Customer>) customerRepositoryImpl.findAll();

        return list;
    }

    public Customer getById(long id) {
        Optional<Customer> existing = customerRepositoryImpl.findById(id);

        return existing.get();
    }

    @Transactional
    public Customer create(Customer cust){
        return customerRepositoryImpl.save(cust);
    }

    @Transactional
    public Customer update(Customer cust){
        Optional<Customer> existing = customerRepositoryImpl.findById(cust.getId());

        return customerRepositoryImpl.save(cust);
    }

    @Transactional
    public void delete(long id){
        Optional<Customer> existing = customerRepositoryImpl.findById(id);

        customerRepositoryImpl.deleteById(id);
    }
}
