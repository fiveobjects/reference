package org.openapex.samples.basic;

public class FilePathEscape {
    public static void main(String[] args) {
        String path1 = "E:\test\filename.png";
        String path2 = "E:\\test\\filename.png";
        System.out.println("Path1: " + path1);
        System.out.println("Path2: " + path2);
    }
}
