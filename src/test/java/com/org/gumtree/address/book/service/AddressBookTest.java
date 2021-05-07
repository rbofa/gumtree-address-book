package com.org.gumtree.address.book.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddressBookTest {

    @Test
    @DisplayName("How many males are in the address book?")
    public void shouldCountNoOfMalesInTheAddressBook() {
        AddressBook addressBook = new AddressBook();
        Assertions.assertEquals(addressBook.getMalesCount(), 3);
    }
}
