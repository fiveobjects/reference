package org.openapex.samples.misc.http;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostJsonData {
    public static void main(String[] args) throws Exception {
        new PostJsonData().postData();
    }

    private void postData() throws Exception {
        URL url = new URL("http://localhost:90/guide/channel");
        String data = createRequestData();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        // Not needed, default is true
        //con.setDoInput(true);
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        con.addRequestProperty("Content-Type", "application/json");
        DataOutputStream outputStream = new DataOutputStream(con.getOutputStream());
        outputStream.writeBytes(data);
        outputStream.flush();
        outputStream.close();
        readResponseStatusAndHeaders(con);
        if (con.getResponseCode() == 200) {
            System.out.println("Output:");
            processResponse(con.getInputStream());
        } else {
            System.out.println("Error");
            processResponse(con.getErrorStream());
        }
    }

    private String createRequestData() {
        JSONObject data = new JSONObject();
        data.put("name", "Star Movies");
        data.put("channelGroup", "Star");
        JSONObject additionalInfo = new JSONObject();
        additionalInfo.put("description", "additional info");
        data.put("additionalInfo", additionalInfo);
        return data.toString();
    }

    /**
     * Reads response code, message and header fields.
     *
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
     *
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
