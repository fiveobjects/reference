package org.openapex.samples.springboot.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("templateController")
public class TemplateController {
    @Value("${test.product.release.year}")
    private String releaseYear;

    @Autowired
    private AbstractEnvironment environment;

    @RequestMapping(path = "/template")
    public ModelAndView getHelloTemplate() {
        System.out.println("Release Year 1: "+releaseYear);
        System.out.println("Release Year 2:"+ environment.getProperty("test.product.release.year"));
        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        model.addObject("message", "Hello World");
        return model;
    }

    @RequestMapping(path = "/template1")
    public String getHelloTemplate(Model model) {
        model.addAttribute("message", "Hello World 1");
        return "hello";
    }

    @RequestMapping(path = "/template2")
    public String getHelloTemplate(ModelMap model) {
        model.addAttribute("message", "Hello World 2");
        return "hello2";
    }

    @RequestMapping(path="/cors")
    @ResponseBody
    public String verifyCors(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:90/guide/company", String.class);
        return result;
    }
}
