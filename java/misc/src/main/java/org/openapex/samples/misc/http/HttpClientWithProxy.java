package org.openapex.samples.misc.http;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * HttpClient class is capable to invoke URL, receive response
 * from server and process data.
 * @author mrityunjoy_saha
 * @version 1.0
 * @since Apex 1.2
 */
public class HttpClientWithProxy {

    /**
     * Creates a new instance of {@code HttpClient}.
     * @param proxyConnection Indicates whether or nor proxy connection to be used.
     */
    public HttpClientWithProxy(boolean proxyConnection) {
        // In case proxy connection is required set additional connection properties.
        if (proxyConnection) {
            setupProxy();
        }
    }

    /**
     * Sets proxy connection related properties.
     */
    private void setupProxy() {
        System.out.println("Setting up proxy configuration");
        // Http proxy properties
        System.setProperty("https.proxyHost", "10.152.45.85");
        System.setProperty("https.proxyPort", "3128");
        // User name and password are optional
        System.setProperty("https.proxyUser", "pdhaval@ntlm.com");
        System.setProperty("https.proxyPassword", "VMware1!");
    }

    /**
     * Main method of the program.
     * @param args Input arguments to the program.
     */
    public static void main(String[] args) {
        HttpClientWithProxy handler = new HttpClientWithProxy(true);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("URL (q to quit):");
            String url = scanner.nextLine();
            if(!url.equalsIgnoreCase("q")) {
                InputStream response = handler.sendRequest(url.trim());
                handler.processResponse(response);
            } else {
                break;
            }
        }
    }

    /**
     * Opens a connection and sends Http request to given URL.
     * @param url URL to be invoked.
     * @return Response as a stream.
     */
    private InputStream sendRequest(String url) {
        try {
            URL urlInstance = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) urlInstance.
                    openConnection();
            // Set timeout in milliseconds
            connection.setConnectTimeout(20000);
            // Set request headers
            addRequestHeaders(connection);
            // Establiish a connection
            connection.connect();
            System.out.println("Using Proxy? "+connection.usingProxy());
            // Read response status and headers
            readResponseStatusAndHeaders(connection);
            // Return response
            return connection.getInputStream();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Adds request headers to connection.
     * @param connection Http URL connection instance.
     */
    private void addRequestHeaders(HttpURLConnection connection) {
        connection.addRequestProperty("Accept", "text/plain");
        connection.addRequestProperty("Accept-Language", "en");
        connection.addRequestProperty("Cache-Control", "no-cache");
    }

    /**
     * Reads response code, message and header fields.
     * @param connection Http URL connection instance.
     * @throws IOException If an error occrred while connecting to server.
     */
    private void readResponseStatusAndHeaders(HttpURLConnection connection) throws
            IOException {
        System.out.println("Response code: " + connection.getResponseCode());
        System.out.println(
                "Response message: " + connection.getResponseMessage());
        System.out.println("Response header: Content-Length: " + connection.
                getHeaderField("Content-Length"));
    }

    /**
     * Prints the response to console.
     * @param response Response stream.
     */
    private void processResponse(InputStream response) {
        if (response == null) {
            System.out.println("No or blank response received");
        } else {
            StringBuilder data = new StringBuilder();
            try {
                int bufferSize = 2048;
                byte[] inputData = new byte[bufferSize];
                int count = 0;
                while ((count = response.read(inputData, 0, bufferSize)) != -1) {
                    data.append(new String(inputData, 0, count, "UTF-8"));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("Data received: " + data.toString());
        }
    }
}
