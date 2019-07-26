package org.openapex.samples.misc.stack;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class CollatorSort57199918 {
    public static void main(String[] args) {
        List<Element> list = Arrays.asList(new Element("abc"), new Element("xyz"), new Element("bde"), new Element("rew"), new Element("aER"),
                new Element("Tre"), new Element("ade"));
        Collator spCollator = Collator.getInstance(new Locale("es", "ES"));
        //list.subList(0, 4).sort((e1, e2)-> spCollator.compare(e1.getValue(), e2.getValue()));
        list.subList(0, 4).sort(Comparator.comparing(Element::getValue, spCollator));
        System.out.println(list);
    }

    private static class MyElementComparator implements Comparator<Element>{
        Collator spCollator = Collator.getInstance(new Locale("es", "ES"));
        public int compare (Element e1, Element e2){
            return spCollator.compare(e1.getValue(), e2.getValue());
        }
    }

    private static class Element {
        private String value;

        public Element(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
