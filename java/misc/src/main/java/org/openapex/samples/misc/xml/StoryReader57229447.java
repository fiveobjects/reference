package org.openapex.samples.misc.xml;

import lombok.Data;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

public class StoryReader57229447 {
    public static void main(String[] args) throws Exception{
        // Read story.xml
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        StoryXMLHandler handler = new StoryXMLHandler();
        parser.parse("/Users/msaha/Work/Projects/Flock/fiveobjects/github/reference/java/misc/src/main/resources/story.xml", handler);
        System.out.println(handler.getItemsList().get(0).getStoryDescription());
    }

    public static class StoryXMLHandler extends DefaultHandler {

        Boolean currentElement = false;
        String currentValue = "";
        ItemStory item = null;
        private ArrayList<ItemStory> itemsList = new ArrayList<>();

        public ArrayList<ItemStory> getItemsList() {
            return itemsList;
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            currentElement = true;
            currentValue = "";
            if (localName.equals("story")) {
                item = new ItemStory();
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            currentElement = false;
            if (localName.equalsIgnoreCase("story_id"))
                item.setId(currentValue);
            else if (localName.equalsIgnoreCase("story_title"))
                item.setStoryTitle(currentValue);
            else if (localName.equalsIgnoreCase("story_date"))
                item.setStoryDate(currentValue);
            else if (localName.equalsIgnoreCase("story_des"))
                item.setStoryDescription(currentValue);
            else if (localName.equalsIgnoreCase("story"))
                itemsList.add(item);
        }
        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (currentElement) {
                currentValue = currentValue +"\\n\\r"+  new String(ch, start, length);
            }
        }
    }
    @Data
    private static  class ItemStory{
        private String id;
        private String storyTitle;
        private String storyDate;
        private String storyDescription;
    }
}
