package org.openapex.tvguide.service;

import org.openapex.tvguide.dbaccess.repository.OwnerRepository;
import org.openapex.tvguide.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class JpaRelationshipService {
    @Autowired
    private OwnerRepository ownerRepository;
    public List<Owner> getOwners(){
        return ownerRepository.findAll();
    }
}
