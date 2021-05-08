package com.org.gumtree.address.book.service;

import com.org.gumtree.address.book.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AddressBookTest {

    @InjectMocks
    private AddressBook addressBook;

    @Mock
    private PeoplesDataParser peoplesDataParser;

    @Test
    @DisplayName("How many males are in the address book?")
    public void shouldCountNoOfMalesInTheAddressBook() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Bill McKnight", "Male", "16/03/77"));
        people.add(new Person("Paul Robinson", "Male", "15/01/85"));
        people.add(new Person("Gemma Lane", "Female", "20/11/91"));
        people.add(new Person("Sarah Stone", "Female", "20/09/80"));
        people.add(new Person("Wes Jackson", "Male", "14/08/74"));
        when(peoplesDataParser.getPeople()).thenReturn(people);
        assertThat(addressBook.getMalesCount()).isEqualTo(3);
        verify(peoplesDataParser, times(1)).getPeople();
    }
}
