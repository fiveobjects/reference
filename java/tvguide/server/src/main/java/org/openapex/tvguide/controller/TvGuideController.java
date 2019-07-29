package org.openapex.tvguide.controller;

import org.openapex.tvguide.model.Channel;
import org.openapex.tvguide.model.Company;
import org.openapex.tvguide.model.ProgramDocument;
import org.openapex.tvguide.service.TvGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "tvGuideController")
//@RestController(value = "tvGuideController")
@RequestMapping(path = "/guide")
@CrossOrigin(maxAge = 3600)

public class TvGuideController {
    @Autowired
    private TvGuideService tvGuideService;

    @RequestMapping(method = RequestMethod.GET, path = "channels")
    @ResponseBody
    public List<Channel> getChannels() {
        return tvGuideService.getChannels();
    }

    @RequestMapping(method = RequestMethod.GET, path = "search-channels")
    @ResponseBody
    public List<Channel> searchChannels(@RequestParam(name = "channelGroup", required = false) String group) {
        return tvGuideService.searchChannels(group);
    }

    @RequestMapping(method = RequestMethod.POST, path = "channel")
    @ResponseBody
    public void createChannel(@RequestBody Channel channel) {
        tvGuideService.createChannel(channel);
    }

    @RequestMapping(method = RequestMethod.GET, path = "programs")
    @ResponseBody
    public List<ProgramDocument> getPrograms() {
        return tvGuideService.getPrograms();
    }

    @RequestMapping(method = RequestMethod.GET, path = "company")
    @ResponseBody
    public List<Company> getCompaniesQueryAnnotation() {
        return tvGuideService.getCompaniesQueryAnnotation();
    }

    @RequestMapping(method = RequestMethod.GET, path = "company-custom")
    public List<Company> getCompaniesCustomQuery() {
        return tvGuideService.getCompaniesCustomQuery();
    }

    @RequestMapping(path="/template")
    public ModelAndView getHelloTemplate(){
        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        model.addObject("message", "Hello World");
        return model;
    }

    @RequestMapping(path="/template1")
    public String getHelloTemplate(Model model){
        model.addAttribute("message", "Hello World 1");
        return "hello";
    }

    @RequestMapping(path="/template2")
    public String getHelloTemplate(ModelMap model){
        model.addAttribute("message", "Hello World 2");
        return "hello2";
    }
}

