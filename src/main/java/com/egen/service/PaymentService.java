package com.egen.service;

import com.egen.model.Payment;
import com.egen.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepositoryImpl;

    public List<Payment> findAll(){
        List<Payment> list = (List<Payment>) paymentRepositoryImpl.findAll();

        return list;
    }

    public Payment getById(long id) {
        Optional<Payment> existing = paymentRepositoryImpl.findById(id);

        return existing.get();
    }

    @Transactional
    public Payment create(Payment payment){
        Optional<Payment> existing = paymentRepositoryImpl.findById(payment.getId());

        return paymentRepositoryImpl.save(payment);
    }

    @Transactional
    public Payment update(Payment payment){
        Optional<Payment> existing = paymentRepositoryImpl.findById(payment.getId());

        return paymentRepositoryImpl.save(payment);
    }

    @Transactional
    public void delete(long id){
        Optional<Payment> existing = paymentRepositoryImpl.findById(id);

        paymentRepositoryImpl.deleteById(id);
    }
}
