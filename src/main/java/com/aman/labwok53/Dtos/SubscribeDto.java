package com.aman.labwok53.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscribeDto {

    private String subscribeId;
    private EventStatus status;


}
