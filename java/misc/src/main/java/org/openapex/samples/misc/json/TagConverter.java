package org.openapex.samples.misc.json;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TagConverter {
    public static void main(String[] args) {
        List<Tag> tags = new ArrayList<>();
        Tag t1 = new Tag("Java");
        Tag t2 = new Tag("Spring");
        tags.add(t1);
        tags.add(t2);
        JSONObject json = new JSONObject();
        for(Tag t : tags){
            json.put(t.name, JSONObject.NULL);
        }

        System.out.println(json);
    }

    private static class Tag{
        public Long id;
        public String name;

        public Tag(String name){
            this.name = name;
        }
    }
}
