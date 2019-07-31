package org.openapex.samples.springboot.template;

import org.springframework.web.client.RestTemplate;

public class Feature {
    public static String getFeature(String url, RestTemplate restTemplate) {
        return restTemplate.postForObject(url, "", String.class);
    }
}
