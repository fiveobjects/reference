package org.openapex.tvguide.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "person")
@Data
public class Owner {
    @Id
    private int ownerId;
    private String name;
    @OneToMany(mappedBy = "owner")
    private List<Dog> dogs;
}
