package org.openapex.tvguide.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
//    @Autowired
//    private SessionFactory sessionFactory;

    @PersistenceContext
    protected EntityManager em;

    public List<Channel> getChannels() {
        System.out.println(channelRepository.findByBIndex(10L));
        System.out.println(channelRepository.findByChannelGroupOrderByBIndex("Star"));

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

    public List<Company> getCompaniesCustomQuery() {
        Query query = new Query();
        boolean someCondition = true;
        if (someCondition) {
            query.fields().exclude("officeIdEmployeeMap");
        }
        return mongoTemplate.find(query, Company.class);
    }

    public List<Channel> searchChannels(String channelName, boolean isRegional) {
        List<Channel> channels = new ArrayList<Channel>();
        //  em.createQuery()
        return channels;
    }
}
