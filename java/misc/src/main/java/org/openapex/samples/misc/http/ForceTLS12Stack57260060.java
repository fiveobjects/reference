package org.openapex.samples.misc.http;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.StringWriter;

public class ForceTLS12Stack57260060 {
    public static void main(String[] args) {
        try {
            System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
            System.setProperty("org.apache.commons.logging.simplelog.showdatetime","true");
            System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http","DEBUG");
            System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.wire","DEBUG");
            //SSLContext sslContext = SSLContext.getInstance("TLS"); // This requires init() call
            //SSLContext sslContext = SSLContexts.custom().build();
            SSLContext sslContext = SSLContextBuilder.create().build();

            @SuppressWarnings("static-access")
            CloseableHttpClient httpclient = HttpClientBuilder.create()
                    .setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext, new String[] { "TLSv1.2" }, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier()))
                    .build();
            HttpHost target = new HttpHost("www.google.com", 443, "https");
            HttpGet getRequest = new HttpGet(target.toURI());
            CloseableHttpResponse resposne = httpclient.execute(getRequest);
            System.out.println(resposne.getEntity().getContentType());
            System.out.println("HTTP Protocol Version:" + getRequest.getProtocolVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
