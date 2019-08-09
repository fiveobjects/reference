package org.openapex.tvguide.controller;

import org.openapex.tvguide.model.Channel;
import org.openapex.tvguide.model.ChannelAdditionalInfo;
import org.openapex.tvguide.model.Company;
import org.openapex.tvguide.model.ProgramDocument;
import org.openapex.tvguide.service.TvGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController(value = "tvGuideController")
@RequestMapping(path = "/guide")
@CrossOrigin(maxAge = 3600)
@Validated
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

    @RequestMapping(method = RequestMethod.POST, path = "channel")
    public void createChannel(@RequestBody @Valid Channel channel) {
        ChannelAdditionalInfo info =(ChannelAdditionalInfo) channel.getAdditionalInfo();
        tvGuideService.createChannel(channel);
    }

    @RequestMapping(method = RequestMethod.GET, path = "programs")
    public List<ProgramDocument> getPrograms() {
        return tvGuideService.getPrograms();
    }

    @RequestMapping(method = RequestMethod.GET, path = "company")
    @CrossOrigin(origins = "http://localhost:59")
    public List<Company> getCompaniesQueryAnnotation() {
        return tvGuideService.getCompaniesQueryAnnotation();
    }

    @RequestMapping(method = RequestMethod.GET, path = "company-custom")
    public List<Company> getCompaniesCustomQuery() {
        return tvGuideService.getCompaniesCustomQuery();
    }

    @RequestMapping(method = RequestMethod.GET, path = "search-channels-new")
    public List<Channel> searchChannels(@RequestParam(name = "channelName", required = false) String channelName, @RequestParam(name = "isRegional",
            required = false) boolean isRegional) {
        return tvGuideService.searchChannels(channelName, isRegional);
    }
}

