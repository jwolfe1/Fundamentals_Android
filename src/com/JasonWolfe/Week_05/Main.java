package com.JasonWolfe.Week_05;

import java.util.ArrayList;
import java.util.List;

class Contact {
    String name;
    String email;

    Contact(String name, String email){
        this.name = name;
        this.email = email;
    }
}

class AddressBook{
    List<Contact> contacts = new ArrayList<>();

    void add(Contact contact){
        contacts.add(contact);
    }

    String searchByName(String name){
        for(Contact entry: contacts){
            if(entry.name.equals(name)){
                return entry.email;
            }
        }
        return null;
    }
}
public class Main {
    public static void main(String[] args){
        AddressBook myAddressBook = new AddressBook();
        Contact jason = new Contact("Jason", "jason@email.com");
        Contact bob = new Contact("Bob", "bob@email.com");

        myAddressBook.add(jason);
        myAddressBook.add(bob);

        System.out.println("Bob's email address is " + myAddressBook.searchByName("Bob"));
    }
}
