package org.openapex.samples.misc.stack;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class DomParser57065266 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader("<poll name=\"language_dependence\" title=\"Language Dependence\" totalvotes=\"170\"><results><result level=\"1\" value=\"No necessary in-game text\" numvotes=\"168\"/><result level=\"2\" value=\"Some necessary text - easily memorized or small crib sheet\" numvotes=\"0\"/><result level=\"3\" value=\"Moderate in-game text - needs crib sheet or paste ups\" numvotes=\"0\"/><result level=\"4\" value=\"Extensive use of text - massive conversion needed to be playable\" numvotes=\"0\"/><result level=\"5\" value=\"Unplayable in another language\" numvotes=\"2\"/></results></poll>"));
            Document doc = dbBuilder.parse(is);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("result");
            String targetValue = "";
            int maxNumVotes = 0;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                int numVotes = Integer.parseInt(element.getAttribute("numvotes"));
                if (numVotes > maxNumVotes) {
                    maxNumVotes = numVotes;
                    targetValue = element.getAttribute("value");
                }
            }
            System.out.println("Value: " + targetValue + " NumVotes: " + maxNumVotes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

