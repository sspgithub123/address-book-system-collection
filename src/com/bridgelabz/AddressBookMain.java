package com.bridgelabz;
/**
 * Program on User Registration Using Regex
 *
 * @author : Shubham Pawar
 * @since : 04/04/2022
 * */
public class AddressBookMain {

    public static void main(String[] args) {
        /**
         * 1st print welcome msg.
         */
        System.out.println("Welcome to Address Book System\n");
        /**
         * We are just calling an object using class name.
         * Simply passing the argument value according to the parameter defined in the constructor.
         */
        Contact details = new Contact("Shubham", "Suresh", "Solapur", "pune",
                "Maharashtra", "ssp671995@gmail.com", 416416, 8530705596L);
        System.out.println("The following contact details is mentioned below : \n");
        System.out.println("First Name : " + details.getFirstName());
        System.out.println("Last Name  : " + details.getLastName());
        System.out.println("Address    : " + details.getAddress());
        System.out.println("City       : " + details.getCity());
        System.out.println("State      : " + details.getState());
        System.out.println("E-mail     : " + details.getEmail());
        System.out.println("Zip Code   : " + details.getZip());
        System.out.println("Phone No   : " + details.getPhoneNumber());
    }
}