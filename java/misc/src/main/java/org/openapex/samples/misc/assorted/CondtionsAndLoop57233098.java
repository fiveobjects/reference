package org.openapex.samples.misc.assorted;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class CondtionsAndLoop57233098 {
    private static List<Person> bidders = new ArrayList<>();
    private static List<Item> items = new ArrayList<>();
    public static final String request_bad  = "ncs|56-2629193|1972-03-28|20190218|77067|6208|3209440|self|-123|-123|-123|0.0|0.0|0.0|0.0|0.0|0.0";
    public static final String request_good = "ncs|56-2629193|1972-03-28|20190218|77067|6208|3209440|self|-123|-123|-123|0.0|0.0|0.0|0.0|0.0|0.0|0.0";
    public static void main(String[] args) {
        int[]a ={1,2,3,4};
        System.out.println(a.length);
        System.out.println(request_bad.split("\\|").length);
        System.out.println(request_good.split("\\|").length);
        bidders.addAll(Arrays.asList(new Person("p1"), new Person("p2")));
        items.addAll(Arrays.asList(new Item("i1"), new Item("i2"), new Item("i3")));
        CondtionsAndLoop57233098 test = new CondtionsAndLoop57233098();
        test.addBid("i1", "p2", 100);
        test.addBid("i1", "p3", 40);
        test.addBid("i4", "p3", 40);
    }

    public void addBid(String itemName, String nameOfBidder, double price) {
        if (itemName == null || nameOfBidder == null) {
            throw new NullPointerException("Name of the bidder cannot be null");
        }
        if (itemName.equals("") || nameOfBidder.equals("") || price <= 0) {
            throw new IllegalArgumentException("Name of the bidder cannot be empty");
        }
        Optional<Person> person = bidders.stream().filter(e -> e.getName().equals(nameOfBidder)).findAny();
        Optional<Item> item = items.stream().filter(e -> e.getName().equals(itemName)).findAny();
        if (person.isPresent()) {
            checkItemAndAddBid(item, person.get(), price);
        } else {
            Person newPerson = new Person(nameOfBidder);
            bidders.add(newPerson);
            System.out.println("Creating a new bidder: "+newPerson.getName());
            checkItemAndAddBid(item, newPerson, price);
        }
    }

    public void checkItemAndAddBid(Optional<Item> item, Person person, double price) {
        if (!item.isPresent()) {
            throw new NoSuchElementException("There is no such Item in the Auction");
        } else {
            item.get().addBid(person, price);
        }
    }

    @Data
    @AllArgsConstructor
    private static class Person {
        private String name;
    }

    @Data
    @AllArgsConstructor
    private static class Item {
        private String name;

        public void addBid(Person person, double price) {
            System.out.println(person.getName() + " bidding " + this.getName() + " with price " + price);
        }
    }
}
