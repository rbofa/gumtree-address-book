package com.org.gumtree.address.book.service;

import com.org.gumtree.address.book.domain.Person;

import java.util.Comparator;

import static java.time.temporal.ChronoUnit.DAYS;

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

    public long getAgeDifferenceInDays(String name1, String name2) {
        Person firstPerson = peoplesDataParser.getPeople()
                .stream()
                .filter(person -> person.getName().equals(name1))
                .findAny().get();

        Person secondPerson = peoplesDataParser.getPeople()
                .stream()
                .filter(person -> person.getName().equals(name2))
                .findAny().get();

        return DAYS.between(firstPerson.getDob(), secondPerson.getDob());
    }
}
