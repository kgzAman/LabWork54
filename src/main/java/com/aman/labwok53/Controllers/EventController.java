package com.aman.labwok53.Controllers;

import com.aman.labwok53.Dtos.EventDto;
import com.aman.labwok53.Services.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EventController {

    private static  final ModelMapper modelMapper = new ModelMapper();
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(path = "/api/events")
    public List<EventDto> getAllEvents(){
        return this.eventService.getAllEvents()
                .stream().map(event -> modelMapper.map(event, EventDto.class))
                .collect(Collectors.toList());

    }



}

