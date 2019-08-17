package org.openapex.samples.springboot.template.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

@RestController("generalController")
public class GeneralController {
    @RequestMapping(path = "/person1")
    public Person getPerson1() {
        return new Person("abc", true);
    }

    @RequestMapping(path = "/person2")
    public Person getPerson2(@PathParam("gh") String x) {
        return new Person("xyz", false);
    }

    @RequestMapping(path = "/urls")
    public List<String> getUrls() {
        return Arrays.asList("http://abc", "http://def", "http://ghe");
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class Person {
        private String name;
        private boolean isKey1;

        public Person(String name, boolean isKey1) {
            this.name = name;
            this.isKey1 = isKey1;
        }

        public String getKey1() {
            return isKey1 ? name : null;
        }

        public String getKey2() {
            return isKey1 ? null : name;
        }
    }

    private static class Person1{
        private String key1;
        private String key2;

        public Person1(String key1, String key2){
            this.key1 = key1;
            this.key2 = key2;
        }

        public String getKey1(){
            return this.key1;
        }

        public String getKey2(){
            return this.key2;
        }
    }
}
