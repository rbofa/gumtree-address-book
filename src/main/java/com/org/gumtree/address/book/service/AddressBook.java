package com.org.gumtree.address.book.service;

import com.org.gumtree.address.book.domain.Person;

import java.util.Comparator;

public class AddressBook {

    private PeoplesDataParser peoplesDataParser;

    public AddressBook() {
        peoplesDataParser = new PeoplesDataParser();
    }

    public long getMalesCount() {
        return peoplesDataParser.getPeople().stream()
                .filter(person -> person.getGender().equals("Male")).count();
    }

    public Person getOldestPerson() {
        return peoplesDataParser.getPeople().stream()
                .min(Comparator.comparing(Person::getDob)).get();
    }
}
