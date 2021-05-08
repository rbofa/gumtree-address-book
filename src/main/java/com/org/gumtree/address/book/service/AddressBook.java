package com.org.gumtree.address.book.service;

import com.org.gumtree.address.book.domain.Person;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;

public class AddressBook {

    private PeoplesDataParser peoplesDataParser;

    public AddressBook() {
        peoplesDataParser = new PeoplesDataParser();
    }

    public long getMalesCount() {
        return peoplesDataParser.getPeople().stream().filter(person -> person.getGender().equals("Male")).count();
    }

    public Person getOldestPerson() {
        return null;
    }
}
