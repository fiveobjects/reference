package org.openapex.tvguide.dbaccess.repository;

import org.openapex.tvguide.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {
    List<Channel> findByChannelGroup(String group);
}
