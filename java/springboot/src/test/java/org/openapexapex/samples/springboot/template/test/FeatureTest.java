package org.openapexapex.samples.springboot.template.test;

import org.junit.Test;
import org.mockito.Mockito;
import org.openapex.samples.springboot.template.Feature;
import org.springframework.data.mongodb.core.mapping.TextScore;
import org.springframework.web.client.RestTemplate;

public class FeatureTest {
    @Test
    public void testFeature() {
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        Mockito.when(restTemplate.postForObject(Mockito.any(String.class),
                Mockito.any(Object.class), Mockito.any(Class.class))).thenReturn("abc");
        System.out.println(Feature.getFeature("http://abc", restTemplate));
    }
}
