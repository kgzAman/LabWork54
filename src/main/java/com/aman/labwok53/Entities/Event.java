package com.aman.labwok53.Entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@Document(collation = "Entity")
@Entity
public class Event extends BaseEntity{
    private String name;

    private LocalDateTime eventTime;
    private String description;
}
