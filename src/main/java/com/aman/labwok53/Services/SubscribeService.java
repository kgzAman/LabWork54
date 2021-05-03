package com.aman.labwok53.Services;


import com.aman.labwok53.Dtos.SubscribeDto;
import com.aman.labwok53.Entities.Event;
import com.aman.labwok53.Entities.Subscribe;
import com.aman.labwok53.Repositories.SubscribeRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
            final Optional<Subscribe> byEventAndEmail =this.subscribeRepositories.findByEventAndEmail(event, email);
            return byEventAndEmail;
        }

        public void delete(String email, SubscribeDto subscribeId){
            this.subscribeRepositories.deleteByEmailAndEmail(email,subscribeId);
        }




}
