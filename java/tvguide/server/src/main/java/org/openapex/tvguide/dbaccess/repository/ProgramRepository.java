package org.openapex.tvguide.dbaccess.repository;

import org.openapex.tvguide.model.ProgramDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends MongoRepository<ProgramDocument, String> {
}
