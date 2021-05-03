package com.aman.labwok53.Entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@Data
@Document(collation = "subscribes")
public class Subscribe extends BaseEntity{

    @DBRef
    private Event event;

    private String email;

    private LocalDateTime timeOfRegister;

}
