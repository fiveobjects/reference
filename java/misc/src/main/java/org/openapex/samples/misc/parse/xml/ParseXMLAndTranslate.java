package org.openapex.samples.misc.parse.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.io.InputStream;

public class ParseXMLAndTranslate {
    public static void main(String[] args) throws Exception {
        Translator translator = new Translator();
        translator.init();
        System.out.println(translator.getTranslation("house", "eng", "bos"));
        System.out.println(translator.getTranslation("igra", "bos", "eng"));
    }

    private static class Translator {
        //String translation = null;
        private Document doc;

        public void init() throws ParserConfigurationException, SAXException, IOException {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream is = Translator.class.getResourceAsStream("/resource/glossary.xml");
            this.doc = builder.parse(new InputSource(is));
        }

        String getTranslation(String wordForTransl, String fromLanguage, String toLanguage)
                throws XPathExpressionException {
            //fromLanguage = "eng";
            //toLanguage = "bos";
            XPathFactory xpathfactory = XPathFactory.newInstance();
            XPath xpath = xpathfactory.newXPath();

            //XPathExpression expr = null; //xpath.compile("//word[eng='house']/bos/text()");
            //XPathExpression expr = xpath.compile("//word['" + wordForTransl + "'='" + wordForTransl + "']/bos/text()");
            XPathExpression expr = null;
            if (fromLanguage == "eng") {
                expr = xpath.compile("//word[eng='" + wordForTransl + "']/bos/text()");
            } else if (fromLanguage == "bos") {
                expr = xpath.compile("//word[bos='" + wordForTransl + "']/eng/text()");
            }

            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;
            String translation = null;
                /*for (int i = 0; i < nodes.getLength(); i++) {
                    //System.out.println(nodes.item(i).getNodeValue());
                    translation = nodes.item(i).getNodeValue();
                }*/
            if (nodes.getLength() > 0) {
                translation = nodes.item(0).getNodeValue();
            }
            //return nodes.item(i).getNodeValue();
            if (translation != null) {
                return translation;
            } else {
                return "We are sorry, there is no translation for this word!";
            }
        }
    }
}
