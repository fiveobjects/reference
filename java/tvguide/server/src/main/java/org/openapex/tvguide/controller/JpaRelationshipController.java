package org.openapex.tvguide.controller;

import org.openapex.tvguide.model.Dog;
import org.openapex.tvguide.model.Owner;
import org.openapex.tvguide.service.JpaRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("jpaRelationshipController")
@RequestMapping(path="/relation")
public class JpaRelationshipController {
    @Autowired
    private JpaRelationshipService jpaRelationshipService;
    @RequestMapping(method = RequestMethod.GET, path="/dogs")
    public List<Dog> getOwners(){
        List<Dog> dogs = new ArrayList<Dog>();
        for (Owner owner: jpaRelationshipService.getOwners()){
            dogs.addAll(owner.getDogs());
        }
        return dogs;
    }
}
