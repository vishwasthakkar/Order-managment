package com.egen.service;

import com.egen.model.Items;
import com.egen.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ItemsService {

    @Autowired
    ItemRepository itemRepositoryImpl;

    public List<Items> findAll(){
        List<Items> list = (List<Items>) itemRepositoryImpl.findAll();

        return list;
    }

    public Items getById(long id) {
        Optional<Items> existing = itemRepositoryImpl.findById(id);

        return existing.get();
    }

    @Transactional
    public Items create(Items item){
        Optional<Items> existing = itemRepositoryImpl.findById(item.getId());

        return itemRepositoryImpl.save(item);
    }

    @Transactional
    public Items update(Items item){
        Optional<Items> existing = itemRepositoryImpl.findById(item.getId());

        return itemRepositoryImpl.save(item);
    }

    @Transactional
    public void delete(long id){
        Optional<Items> existing = itemRepositoryImpl.findById(id);

        itemRepositoryImpl.deleteById(id);
    }
}
