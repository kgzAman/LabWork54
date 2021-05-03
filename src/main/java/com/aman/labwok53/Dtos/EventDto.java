package com.aman.labwok53.Dtos;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventDto {
    private String id;
    private LocalDateTime localDateTime;
    private String name;
    private String description;
}
