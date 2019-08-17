package org.openapex.tvguide.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="item")
@Data
public class Item {
    @Id
    private String value;
    private String description;

    public Item(){
    }

    public Item(String value) {
        this.value = value;
    }
}
