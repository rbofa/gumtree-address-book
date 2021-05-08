package com.org.gumtree.address.book.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    public void shouldParseFilePersonTest() {
        Person person = new Person("Bill McKnight", "Male", "16/03/77");
        assertThat(person.getName()).isEqualTo("Bill McKnight");
        assertThat(person.getGender()).isEqualTo("Male");
        assertThat(person.getDob().getDayOfMonth()).isEqualTo(16);
        assertThat(person.getDob().getMonthValue()).isEqualTo(3);
        assertThat(person.getDob().getYear()).isEqualTo(1977);
    }
}
