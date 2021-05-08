package com.org.gumtree.address.book.domain;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public final class Person {
    private final @NonNull String name;
    private final @NonNull String gender;
    private final @NonNull LocalDate dob;

    public Person(String name, String gender, String dob) {
        this.name = name;
        this.gender = gender;

        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("d/M/")
                .optionalStart()
                .appendValueReduced(ChronoField.YEAR, 2, 2, 1900)
                .optionalEnd()
                .toFormatter();

        this.dob = LocalDate.parse(dob, formatter);
    }
}

