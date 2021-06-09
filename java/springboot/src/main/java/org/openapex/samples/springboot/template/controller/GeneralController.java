package org.openapex.samples.springboot.template.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.*;
import javax.websocket.server.PathParam;

@CrossOrigin(origins = "*")
@RestController("generalController")
public class GeneralController {
    static {
        disableSslVerification();
    }

    private static void disableSslVerification() {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path = "/summary")
    public String getSummary() {
        return getData("getSummary");
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "vRealizeOpsToken df6b8f0d-dfba-42de-bb87-5f52ec0b5e47::7a934318-e050-4c31-a850-097554aef4e2");
        headers.add("X-vRealizeOps-API-use-unsupported", "true");
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        return headers;
    }

    @RequestMapping(path = "/license")
    public String getLicense() {
        return getData("getLicense");
    }

    private String getData(String name){
        HttpHeaders headers = createHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String response = restTemplate.exchange("https://10.112.81.77/suite-api/internal/costdriver/"+name+"?qualifierId=__default__",
                HttpMethod.GET, entity, String.class).getBody();
        return response;
    }

    @RequestMapping(path = "/facilities")
    public String getFacilities() {
        return getData("getFacilities");
    }

    @RequestMapping(path = "/maintenance")
    public String getMaintenance() {
        return getData("getMaintenance");
    }

    @RequestMapping(path = "/additional")
    public String getAdditional() {
        return getData("getAdditionalCosts");
    }

    @RequestMapping(path = "/network")
    public String getNetwork() {
        return getData("getNetwork");
    }

    @RequestMapping(path = "/server")
    public String getServer() {
        return getData("getServerGroups");
    }

    @RequestMapping(path = "/storage")
    public String getStorage() {
        return getData("getStorageCategory");
    }

    @RequestMapping(path = "/labor")
    public String getLabor() {
        return getData("getLabor");
    }

    @RequestMapping(path = "/applications")
    public String getApplications() {
        return getData("getApplicationCosts");
    }

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

    private static class Person1 {
        private String key1;
        private String key2;

        public Person1(String key1, String key2) {
            this.key1 = key1;
            this.key2 = key2;
        }

        public String getKey1() {
            return this.key1;
        }

        public String getKey2() {
            return this.key2;
        }
    }
}
