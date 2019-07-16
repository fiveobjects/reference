package org.openapex.tvguide.controller;

import org.openapex.tvguide.model.Channel;
import org.openapex.tvguide.model.ProgramDocument;
import org.openapex.tvguide.service.TvGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController(value = "tvGuideController")
@RequestMapping(path = "/guide")
public class TvGuideController {
    @Autowired
    private TvGuideService tvGuideService;

    @RequestMapping(method = RequestMethod.GET, path = "channels")
    public List<Channel> getChannels() {
        return tvGuideService.getChannels();
    }

    @RequestMapping(method = RequestMethod.GET, path = "search-channels")
    public List<Channel> searchChannels(@RequestParam(name = "channelGroup", required = false) String group) {
        return tvGuideService.searchChannels(group);
    }
    @RequestMapping(method = RequestMethod.POST, path="channel")
    public void createChannel(@RequestBody Channel channel){
        tvGuideService.createChannel(channel);
    }

    @RequestMapping(method = RequestMethod.GET, path = "programs")
    public List<ProgramDocument> getPrograms() {
        return tvGuideService.getPrograms();
    }
}

