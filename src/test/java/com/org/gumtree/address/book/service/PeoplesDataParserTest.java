package com.org.gumtree.address.book.service;

import com.org.gumtree.address.book.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Address Book Data Parsing Scenario")
public class PeoplesDataParserTest {

    @Test
    @DisplayName("Fetching the peoples data from a given file")
    public void shouldReturnAllPeoplesData() {
        PeoplesDataParser peoplesDataParser = new PeoplesDataParser("AddressBook");
        List<Person> peoples = peoplesDataParser.getPeople();

        assertThat(peoples.size()).isEqualTo(5);
        assertThat(peoples.get(0).getName()).isEqualTo("Bill McKnight");
        assertThat(peoples.get(0).getGender()).isEqualTo("Male");
        assertThat(peoples.get(0).getDob()).isEqualTo(LocalDate.of(1977, 03, 16));
    }

    @Test
    public void whenExceptionThrownThenAssertionSucceeds() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            new PeoplesDataParser("FileIssues");
        });

        String expectedMessage = "Unable to read address book input file";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }
}
