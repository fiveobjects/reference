package org.openapex.samples.springboot.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller("forwardController")
public class ForwardController {
    @Autowired
    private TemplateController templateController;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path = "/greetings")
    public ModelAndView greetings() {
        return new ModelAndView("forward:/template");
    }

    @RequestMapping(path = "/greetings1")
    public String greetings1() {
        return "forward:/template1";
    }

    @RequestMapping(path = "/greetings2")
    @ResponseBody
    public String greetings2(ModelMap modelMap) {
        return restTemplate.getForEntity("http://localhost:92/template2", String.class).getBody();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

}
