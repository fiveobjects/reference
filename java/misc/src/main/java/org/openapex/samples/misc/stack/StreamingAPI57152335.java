package org.openapex.samples.misc.stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamingAPI57152335 {
    public static void main(String[] args) {
        // Create attribute values
        List<AttributeValue> attributeList = createAttributes();
        // Create empty options where the result will be populated
        List<AttributeOption> optionList = new ArrayList<AttributeOption>();

        // Filter and add in traditional way
        exampleCurrentWay(attributeList, optionList);
        System.out.println("Attributes: " + attributeList);
        System.out.println("Options: " + optionList);

        // Resetting option list
        optionList = new ArrayList<AttributeOption>();
        // Filter and add in streaming api way
        exampleStreamingApiWay(attributeList, optionList);
        System.out.println("Attributes: " + attributeList);
        System.out.println("Options: " + optionList);

        // Resetting option list
        optionList = new ArrayList<AttributeOption>();
        // Streaming api way with null list as input
        exampleStreamingApiWay(null, optionList);
        System.out.println("Options: " + optionList);
    }
    // Traditional loop way
    private static void exampleCurrentWay(List<AttributeValue> attributeList, List<AttributeOption> optionList) {
        if (attributeList != null) {
            for (AttributeValue aValue : attributeList) {
                if (aValue.getAttributeType().equalsIgnoreCase("Select")) {
                    //AttributeOption aOption = service.getAttributeOption(accessToken, value.getId());
                    AttributeOption aOption = new AttributeOption(aValue.getCode());
                    aOption.setAttributeCode(aValue.getCode());
                    optionList.add(aOption);
                }
            }
        }
    }
    // Use streaming api
    private static void exampleStreamingApiWay(List<AttributeValue> attributeList, List<AttributeOption> optionList) {
        optionList.addAll(Optional.ofNullable(attributeList).map(Collection::stream).orElseGet(Stream::empty).filter(attribute -> attribute.getAttributeType().equals("Select"))
                .map(attribute -> new AttributeOption(attribute.getCode())).collect(Collectors.toList()));
    }

    private static List<AttributeValue> createAttributes() {
        List<AttributeValue> attribute = new ArrayList<AttributeValue>();
        attribute.add(new AttributeValue("Select", "001"));
        attribute.add(new AttributeValue("Abc", "002"));
        attribute.add(new AttributeValue("Select", "003"));
        attribute.add(new AttributeValue("Select", "004"));
        attribute.add(new AttributeValue("Xyz", "005"));
        return attribute;
    }
    // AttributeValue class
    private static class AttributeValue {
        private String attributeType;
        private String code;

        public AttributeValue(String attributeType, String code) {
            this.attributeType = attributeType;
            this.code = code;
        }

        public String getAttributeType() {
            return attributeType;
        }

        public void setAttributeType(String attributeType) {
            this.attributeType = attributeType;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return "AttributeValue{" +
                    "attributeType='" + attributeType + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }
    }
    // AttributeOption class
    private static class AttributeOption {
        private String attributeCode;

        public AttributeOption(String attributeCode) {
            this.attributeCode = attributeCode;
        }

        public String getAttributeCode() {
            return attributeCode;
        }

        public void setAttributeCode(String attributeCode) {
            this.attributeCode = attributeCode;
        }

        @Override
        public String toString() {
            return "AttributeOption{" +
                    "attributeCode='" + attributeCode + '\'' +
                    '}';
        }
    }
}
