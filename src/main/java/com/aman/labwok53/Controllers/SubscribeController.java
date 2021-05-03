package com.aman.labwok53.Controllers;

import com.aman.labwok53.Dtos.EventStatus;
import com.aman.labwok53.Dtos.SubscribeCreatDto;
import com.aman.labwok53.Dtos.SubscribeDto;
import com.aman.labwok53.Entities.Event;
import com.aman.labwok53.Entities.Subscribe;
import com.aman.labwok53.Exeptions.ResourceNotFoundException;
import com.aman.labwok53.Services.EventService;
import com.aman.labwok53.Services.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/subscribe")
public class SubscribeController {
    private static  final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private final SubscribeService subscribeService;

    @Autowired
    private final EventService eventService;

    @PostMapping
    public SubscribeDto subscribe(@RequestBody SubscribeCreatDto subscribeCreatDto) {

        Event event = this.eventService.findById(subscribeCreatDto.getEventId())
                .orElseThrow(() -> new ResourceNotFoundException("Not found event with ID:%s", subscribeCreatDto.getEventId()));

        final Optional<Subscribe> byEventAndEmail = this.subscribeService.findByEventAndEmail(event, subscribeCreatDto.getEmail());

        if (byEventAndEmail.isPresent()) {
            return SubscribeDto.builder()
                    .subscribeId(byEventAndEmail.get().getId())
                    .status(EventStatus.SUBSCRIBED)
                    .build();
        }

        if(LocalDateTime.now().isAfter(event.getEventTime())){
            throw new IllegalArgumentException("Unable event");
        }

        final Subscribe subscribe = this.subscribeService.subscribe(event, subscribeCreatDto.getEmail());
        return SubscribeDto.builder()
                .subscribeId(byEventAndEmail.get().getId())
                .status(EventStatus.SUBSCRIBE)
                .build();
    }


    @DeleteMapping("/{email}")
    public void delete(@PathVariable String email, @PathVariable String subscribeID){
        this.subscribeService.delete(email,subscribeID);

    }

    @GetMapping("/{email}")
    public List<SubscribeDto> getAllSubByEmail(@PathVariable String email){
        return this.subscribeService.getAllSubByEmail(email)
                .stream().map(Subscribe->modelMapper.map(Subscribe,SubscribeDto.class))
                .collect(Collectors.toList());
    }



}
