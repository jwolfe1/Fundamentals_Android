package com.JasonWolfe.Week_09;

abstract class Contact {
    private String name;

    Contact(String name) {
        this.name = name;
    }

    abstract public void contact();
}

class EmailContact extends Contact {
    private String email;

    EmailContact(String name, String email){
        super(name);
        this.email = email;
    }

    @Override
    public void contact() {
        System.out.println("Emailing " + email);
    }
}

class PhoneContact extends Contact {
    private String phoneNumber;

    PhoneContact(String name, String phoneNumber) {
        super(name);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void contact() {
        System.out.println("Calling " + phoneNumber);
    }
}

public class Main {

    public static void main(String[] args) {
        PhoneContact john = new PhoneContact("john", "5551234567");
        EmailContact steve = new EmailContact("steve", "steve@email.com");

        john.contact();
        steve.contact();
    }
}
