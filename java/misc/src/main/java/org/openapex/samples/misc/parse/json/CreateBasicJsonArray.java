package org.openapex.samples.misc.parse.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CreateBasicJsonArray {
    public static void main(String[] args) {
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name","Sam");
        jsonObject1.put("age",7);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name","David");
        jsonObject2.put("age",10);

        JSONArray jsonObjects= new JSONArray();
        jsonObjects.put(jsonObject1);
        jsonObjects.put(jsonObject2);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fans", jsonObjects);

        System.out.println(jsonObject);
    }
}
