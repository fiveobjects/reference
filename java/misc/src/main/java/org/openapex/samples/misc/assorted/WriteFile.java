package org.openapex.samples.misc.assorted;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class WriteFile {
    public static void main(String[] args) {
        int[][] values = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] val : values) {
            System.out.println(Arrays.toString(val));
        }
        saveFile(15);
    }

    public static void saveFile(int score) {
        try {
            FileWriter fos = new FileWriter("score.txt", true);
            PrintWriter pw = new PrintWriter(fos);
            pw.println(score);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
