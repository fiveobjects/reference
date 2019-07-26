package org.openapex.tvguide.service;

import org.openapex.tvguide.dbaccess.repository.ChannelRepository;
import org.openapex.tvguide.dbaccess.repository.CompanyRepository;
import org.openapex.tvguide.dbaccess.repository.ProgramRepository;
import org.openapex.tvguide.model.Channel;
import org.openapex.tvguide.model.Company;
import org.openapex.tvguide.model.ProgramDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvGuideService {
    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private ProgramRepository programRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Channel> getChannels() {
        return channelRepository.findAll();
    }

    public List<Channel> searchChannels(String group) {
        return channelRepository.findByChannelGroup(group);
    }

    public void createChannel(Channel channel) {
        channelRepository.save(channel);
    }

    public List<ProgramDocument> getPrograms() {
        return programRepository.findAll();
    }

    public List<Company> getCompaniesQueryAnnotation() {
        return companyRepository.getCompanies();
    }

    public List<Company> getCompaniesCustomQuery(){
        Query query = new Query();
        boolean someCondition = true;
        if(someCondition) {
            query.fields().exclude("officeIdEmployeeMap");
        }
        return mongoTemplate.find(query, Company.class);
    }
}
