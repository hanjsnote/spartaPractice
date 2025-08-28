package org.example.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "coat")
@DiscriminatorValue(value = "C")
public class Coat extends Product {

    private Integer size;

}
