package com.aman.labwok53.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public abstract class BaseEntity {
@Id
    private String id;
}
