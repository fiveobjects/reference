package org.openapex.samples.misc.parse.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;

public class ModifyResponse {
    public static void main(String[] args) {
        //Response response = Seller.postSeller(environmentURI, someinput);
        //String responseString = response.asString();
        String responseString = "{ 'data': [{ 'Id': '1', 'Number': 'G24101457', 'oldDate': '2016-01-01', 'currentDate': '2019-02-23' }, { 'Id': '2', 'Number': 'G24101457', 'oldDate': '2016-01-01', 'currentDate': '2019-02-23' } ] }";
        JSONObject responseObject = new JSONObject(responseString);
        JSONArray dataArray = responseObject.getJSONArray("data");

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject jsonObject = dataArray.getJSONObject(i);
            //Here I have update "currentDate": "2019-02-23" to todays date and have to pass that as someinput string
            jsonObject.put("currentDate", new Date());
        }

        System.out.println("Modified data: " + responseObject);
        //Again I have to call this API
        //Response response = Seller.postSeller(environmentURI, responseObject.toString());
    }
}
