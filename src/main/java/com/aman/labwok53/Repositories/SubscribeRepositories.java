package com.aman.labwok53.Repositories;

import com.aman.labwok53.Dtos.SubscribeDto;
import com.aman.labwok53.Entities.Event;
import com.aman.labwok53.Entities.Subscribe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SubscribeRepositories extends MongoRepository<Subscribe,String> {

    Optional<Subscribe> findByEventAndEmail(Event event , String email);
    void deleteByEmailAndEmail(String email, String subscribeId);

    List<>


}
