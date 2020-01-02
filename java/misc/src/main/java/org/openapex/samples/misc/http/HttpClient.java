package org.openapex.samples.misc.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * HttpClient class is capable to invoke URL, receive response
 * from server and process data.
 * @author mrityunjoy_saha
 * @version 1.0
 * @since Apex 1.2
 */
public class HttpClient {

    /**
     * Creates a new instance of {@code HttpClient}.
     * @param proxyConnection Indicates whether or nor proxy connection to be used.
     */
    public HttpClient(boolean proxyConnection) {
        // In case proxy connection is required set additional connection properties.
        if (proxyConnection) {
            setupProxy();
        }
    }

    /**
     * Sets proxy connection related properties.
     */
    private void setupProxy() {
        // Http proxy properties
        System.getProperties().put("http.proxyHost", "URL");
        System.getProperties().put("http.proxyPort", "Port");
        // User name and password are optional
        System.getProperties().put("http.proxyUser", "UserName");
        System.getProperties().put("http.proxyPassword", "Password");
    }

    /**
     * Main method of the program.
     * @param args Input arguments to the program.
     */
    public static void main(String[] args) {
        HttpClient handler = new HttpClient(false);
        InputStream response = handler.sendRequest("http://localhost/index.php");
        handler.processResponse(response);
    }

    /**
     * Opens a connection and sends Http request to given URL.
     * @param url URL to be invoked.
     * @return Response as a stream.
     */
    private InputStream sendRequest(String url) {
        try {
            URL urlInstance = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlInstance.
                    openConnection();
            // Set timeout in milliseconds
            connection.setConnectTimeout(20000);
            // Set request headers
            addRequestHeaders(connection);
            // Establiish a connection
            connection.connect();
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
