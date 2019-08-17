package org.openapex.samples.misc.parse.json;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ParseJsonIntoMap {
    public static void main(String[] args) {
        String data="{\"name\":\"Nataraj\", \"job\":\"Programmer\",\"property\":{\"chair\":\"my\",\"table\":\"brothers\",\"cabinet\":\"mothers\"}}";
        JSONObject parsedData = new JSONObject(data);
        A a = new A();
        a.setName(parsedData.getString("name"));
        a.setJob(parsedData.getString("job"));
        JSONObject propertyMap = parsedData.getJSONObject("property");
        for (String key : propertyMap.keySet()) {
            a.getProperty().put(key, propertyMap.getString(key));
        }
        System.out.println("Output: "+a);
    }

    public static class A{
        String name;
        String job;
        Map<String, String> property = new HashMap<>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public Map<String, String> getProperty() {
            return property;
        }

        public void setProperty(Map<String, String> property) {
            this.property = property;
        }

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    ", job='" + job + '\'' +
                    ", property=" + property +
                    '}';
        }
    }
}
