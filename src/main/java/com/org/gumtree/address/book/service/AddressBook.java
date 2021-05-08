package com.org.gumtree.address.book.service;

public class AddressBook {

    private PeoplesDataParser peoplesDataParser;

    public AddressBook() {
        peoplesDataParser = new PeoplesDataParser();
    }

    public long getMalesCount() {
        return peoplesDataParser.getPeople().stream().filter(person -> person.getGender().equals("Male")).count();
    }
}
