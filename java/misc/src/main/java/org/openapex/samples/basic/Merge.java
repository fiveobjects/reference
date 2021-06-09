package org.openapex.samples.basic;

import java.util.*;
import java.io.*;

public class Merge{
  public static void main(String[] args) throws Exception{
    String dataPath = args[0];
    String metadataPath = args[1];
    String outputPath = args[2];
    Map<String, Map<String, String>> metadata = readAndIndexMetadata(metadataPath);
    convertData(dataPath, outputPath, metadata);
  }

  private static Map<String, Map<String, String>> readAndIndexMetadata(String metadataPath) throws Exception{
    Map<String, Map<String, String>> result = new HashMap<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File(metadataPath)));
    String line = "";
    while ((line= reader.readLine())!=null){
      String[] values = line.split(",");
      if(!result.containsKey(values[0])){
        result.put(values[0], new HashMap<String, String>());
      }
      result.get(values[0]).put(values[1], values[2]);
    }
    reader.close();
    return result;
  }

  private static void convertData(String dataPath, String outputPath, Map<String, Map<String, String>> metadata) throws Exception{
    BufferedReader reader = new BufferedReader(new FileReader(new File(dataPath)));
    BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputPath)));
    String line = "";
    System.out.println(metadata);
    writer.write("AWS-Billing-Account,AWS-Account,AWS-Service-Category,Month,cost_before_chargeback\n");
    while ((line= reader.readLine())!=null){
      if(line.startsWith("AWS-Billing-Account")){
        continue;
      }
      String[] values = line.split(",");
      if(values.length < 4){
        System.out.println("Invalid entry: "+line);
      }
      StringBuilder result = new StringBuilder("");
      result.append(metadata.get("AWS-Billing-Account").get(values[0])).append(",");
      result.append(metadata.get("AWS-Account").get(values[1])).append(",");
      result.append(metadata.get("AWS-Service-Category").get(values[2])).append(",");
      result.append(metadata.get("Past-12-Months").get(values[3])).append(",");
      result.append(values[4]);
      writer.write(result.toString()+"\n");
    }
    writer.flush();
    writer.close();
    reader.close();
  }
}
