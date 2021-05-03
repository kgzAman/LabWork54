package com.aman.labwok53.Repositories;

import com.aman.labwok53.Entities.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepositories extends MongoRepository<Event,String> {

    List<Event> findByName(String name);
    List<Event> findByOrEventTime();

}
