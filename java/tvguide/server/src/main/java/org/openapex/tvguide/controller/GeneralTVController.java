package org.openapex.tvguide.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController("generalTVController")
@RequestMapping("/general")
public class GeneralTVController {
    @RequestMapping(path = "/urls")
    public List<Item> getItems() {
        return Arrays.asList(new Item("http://abc"), new Item("http://def"), new Item("http://ghe"));
    }

    public static class Item {
        private String value;

        public Item(String value) {
            this.value = value;
        }
    }
}
