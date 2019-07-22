package org.openapex.samples.misc.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamingAPI57152335 {
    public static void main(String[] args) {
        List<AttributeValue> attributeList = createAttributes();
        List<AttributeOption> optionList = new ArrayList<AttributeOption>();
        exampleCurrentWay(attributeList, optionList);
        System.out.println("Attributes: "+attributeList);
        System.out.println("Options: "+optionList);
        optionList = new ArrayList<AttributeOption>();
        exampleStreamingApiWay(attributeList, optionList);
        System.out.println("Attributes: "+attributeList);
        System.out.println("Options: "+optionList);
    }

    private static void exampleCurrentWay(List<AttributeValue> attributeList, List<AttributeOption> optionList){
        if(attributeList != null){
            for(AttributeValue aValue : attributeList){
                if(aValue.getAttributeType().equalsIgnoreCase("Select")){
                    //AttributeOption aOption = service.getAttributeOption(accessToken, value.getId());
                    AttributeOption aOption = new AttributeOption(aValue.getCode());
                    aOption.setAttributeCode(aValue.getCode());
                    optionList.add(aOption);
                }
            }
        }
    }

    private static void exampleStreamingApiWay(List<AttributeValue> attributeList, List<AttributeOption> optionList){
        if(attributeList != null){
            optionList.addAll(attributeList.stream().filter(attribute -> attribute.getAttributeType().equals("Select"))
                    .map(attribute -> new AttributeOption(attribute.getCode())).collect(Collectors.toList()));
        }
    }

    private static List<AttributeValue> createAttributes(){
        List<AttributeValue> attribute = new ArrayList<AttributeValue>();
        attribute.add(new AttributeValue("Select", "001"));
        attribute.add(new AttributeValue("Abc", "002"));
        attribute.add(new AttributeValue("Select", "003"));
        attribute.add(new AttributeValue("Select", "004"));
        attribute.add(new AttributeValue("Xyz", "005"));
        return attribute;
    }

    private static  class AttributeValue {
        private String attributeType;
        private String code;

        public AttributeValue(String attributeType, String code){
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

    private static class AttributeOption {
        private String attributeCode;

        public AttributeOption(String attributeCode){
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
