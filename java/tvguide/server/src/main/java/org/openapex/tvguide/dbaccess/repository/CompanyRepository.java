package org.openapex.tvguide.dbaccess.repository;

import org.openapex.tvguide.model.Company;
import org.openapex.tvguide.model.ProgramDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {
    @Query(value="{}", fields = "{'info':1}")
    public List<Company> getCompanies();
}
