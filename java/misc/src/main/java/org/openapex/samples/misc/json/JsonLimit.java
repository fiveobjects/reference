package org.openapex.samples.misc.json;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonLimit {
    public static void main(String[] args) {
        JSONArray array = new JSONArray();

        for (int g = 0; g < 500000; g++) {
            JSONObject object = new JSONObject();
            try {
                object.put("name", g + "");
                object.put("mobile", g + "");

            } catch (Exception e) {
                e.printStackTrace();
            }
            array.put(object);
        }
        System.out.println(array.length());
    }
}
