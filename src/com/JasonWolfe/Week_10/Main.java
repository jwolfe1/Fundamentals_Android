package com.JasonWolfe.Week_10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Contact {
    public String name;
    public String email;

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void display() {
        System.out.println("Name: " + name + ", Email: " + email);
    }
}

class AddressBook implements Iterable<Contact> {
    private List<Contact> addressBook = new ArrayList<>();

    public void add(Contact c) {
        addressBook.add(c);
    }

    @Override
    public Iterator<Contact> iterator() {
        return addressBook.iterator();
    }
}

public class Main {

    public static void main(String[] args) {

        Contact steve = new Contact("steve", "steve@email.com");
        Contact mike = new Contact("mike", "mike@mike.com");

        List<Contact> addressBook = new ArrayList<>();

        addressBook.add(steve);
        addressBook.add(mike);

        for(Contact contact : addressBook) {
            contact.display();
        }
    }
}
