package org.openapex.tvguide.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cat")
public class Cat extends Animal{
    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;
}
