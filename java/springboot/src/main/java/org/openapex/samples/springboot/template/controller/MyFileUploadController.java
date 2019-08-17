package org.openapex.samples.springboot.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller("myFileUploadController")
@RequestMapping("/upload")
@CrossOrigin(maxAge = 3600)
public class MyFileUploadController {
    @RequestMapping(method = RequestMethod.POST, path = "csv")
    public String uploadFile(@RequestParam(name = "myfile") MultipartFile file, Model model) throws IOException {
        System.out.println(new String(file.getBytes()));
        String fileName = file.getOriginalFilename().toLowerCase();

        if(fileName.contains(".csv") == false) {
            model.addAttribute("message", "Only .csv is acceptable");
            return "home";
        }

        return "success";
    }
}
