package org.openapex.tvguide.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Animal {
    @Id
    private int id;
    private String name;
    private String color;
}
