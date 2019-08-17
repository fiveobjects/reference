package org.openapex.samples.springboot.template.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/servelt-upload")
@MultipartConfig
public class MyFileUploadServelt extends HttpServlet {
    private static final String CONTENT_DISPOSITION_KEY = "content-disposition";
    private static final String FILE_NAME_KEY = "filename";
    private static final int BUFFER_SIZE = 2048;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Content Type: " + req.getContentType());
        System.out.println("Content Length: " + req.getContentLength());
        System.out.println("Parts: " + req.getParts().toString());
        System.out.println("Part 1: " + req.getPart("myfile"));
        // Read parts. Also can be read by directly calling req.getPart(fileName)
        for (Part part : req.getParts()) {
            System.out.println("File Name: " + getFileName(part));
            System.out.println("File Content: " + getTextFromPart(part));
        }
    }

    private String getFileName(Part part) {
        for (String contentDisposition : part.getHeader(CONTENT_DISPOSITION_KEY).split(";")) {
            if (contentDisposition.trim().startsWith(FILE_NAME_KEY)) {
                return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }


    private String getTextFromPart(Part part) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
        StringBuilder value = new StringBuilder();
        char[] buffer = new char[BUFFER_SIZE];
        for (int length = 0; (length = reader.read(buffer)) > 0; ) {
            value.append(buffer, 0, length);
        }
        return value.toString();
    }
}
