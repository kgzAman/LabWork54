package com.aman.labwok53.Services;


import com.aman.labwok53.Dtos.SubscribeDto;
import com.aman.labwok53.Entities.Event;
import com.aman.labwok53.Entities.Subscribe;
import com.aman.labwok53.Repositories.SubscribeRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscribeService {

    private final SubscribeRepositories subscribeRepositories;


        public Subscribe subscribe(Event event,String email){
            Subscribe subscribe = Subscribe.builder()
                    .timeOfRegister(LocalDateTime.now())
                    .email(email)
                    .event(event)
                    .build();
            return this.subscribeRepositories.save(subscribe);
        }

        public Optional<Subscribe> findByEventAndEmail(Event event, String email){
            return this.subscribeRepositories.findByEventAndEmail(event, email);
        }

        public void delete(String email, String subscribeId){
            this.subscribeRepositories.deleteByEmailAndEmail(email, subscribeId);
        }

        public List<SubscribeDto> getAllSub(String email){
            subscribeRepositories.f
        }




}
