package com.org.gumtree.address.book.service;

import com.org.gumtree.address.book.domain.Person;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeoplesDataParser {

    private static String fileName = "input/AddressBook";
    private List<Person> people;

    public PeoplesDataParser() {
        this.people = loadAndReadAddressBookFile();
    }

    public List<Person> getPeople() {
        return this.people;
    }

    private List<Person> loadAndReadAddressBookFile() {
        final URL url = getClass().getClassLoader().getResource(fileName);
        try (Stream<String> lines = Files.lines(Paths.get(url.getPath()))) {
            return lines.map(line -> {
                final String[] lineSplit = line.split(",");
                return new Person(lineSplit[0].trim(), lineSplit[1].trim(), lineSplit[2].trim());
            }).collect(Collectors.toList());

        } catch (Exception ex) {
            //TODO: log : "Unable to read address book input file"
        }

        return new ArrayList<>();
    }

}
