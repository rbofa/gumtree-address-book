package com.org.gumtree.address.book.service;

import com.org.gumtree.address.book.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DisplayName("Address Book Scenario")
@ExtendWith(MockitoExtension.class)
public class AddressBookTest {

    @InjectMocks
    private AddressBook addressBook;

    @Mock
    private PeoplesDataParser peoplesDataParser;

    @Test
    @DisplayName("How many males are in the address book?")
    public void shouldCountNoOfMalesInTheAddressBook() {
        when(peoplesDataParser.getPeople()).thenReturn(getMockPeoplesData());
        assertThat(addressBook.getMalesCount()).isEqualTo(3);
        verify(peoplesDataParser, times(1)).getPeople();
    }

    @Test
    @DisplayName("who is the oldest person in the address book?")
    public void shouldReturnOldestPersonFromTheAddressBook() {
        when(peoplesDataParser.getPeople()).thenReturn(getMockPeoplesData());
        assertThat(addressBook.getOldestPerson().getName()).isEqualTo("Wes Jackson");
        verify(peoplesDataParser, times(1)).getPeople();
    }

    private List<Person> getMockPeoplesData() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Bill McKnight", "Male", "16/03/77"));
        people.add(new Person("Paul Robinson", "Male", "15/01/85"));
        people.add(new Person("Gemma Lane", "Female", "20/11/91"));
        people.add(new Person("Sarah Stone", "Female", "20/09/80"));
        people.add(new Person("Wes Jackson", "Male", "14/08/74"));

        return people;
    }

}
