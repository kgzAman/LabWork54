package com.aman.labwok53.Services;


import com.aman.labwok53.Entities.Event;
import com.aman.labwok53.Repositories.EventRepositories;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@Data
public class EventService {


    private EventRepositories eventRepositories;


    public List<Event> getAllEvents(){return eventRepositories.findAll(); }


    public Optional<Event> findById(String eventId) {
        return eventRepositories.findById(eventId);
    }




}


