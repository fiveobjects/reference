package org.openapex.samples.springboot.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("templateController")
public class TemplateController {

    @RequestMapping(path = "/template")
    public ModelAndView getHelloTemplate() {
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
}
