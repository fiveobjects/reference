package org.openapex.samples.springboot.template.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController("myFileUploadController")
@RequestMapping("/upload")
public class MyFileUploadController {
    @RequestMapping(method = RequestMethod.POST, path = "csv")
    public void uploadFile(@RequestParam(name = "myfile") MultipartFile file) throws IOException {
        System.out.println(new String(file.getBytes()));
    }
}
