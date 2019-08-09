package org.openapex.tvguide.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "dog")
@Data
public class Dog extends Animal {
    //@Id
    private int dogId;
    private int barkingIntensity;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
