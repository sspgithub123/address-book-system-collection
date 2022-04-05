package com.bridgelabz;
/**
 * Program on User Registration Using Regex
 *
 * @author : Shubham Pawar
 * @since : 04/04/2022
 * */
/**
 * UC1 :- Ability to create a Contacts in Address Book with first and last names, address,
 *        city, state, zip, phone number and email...
 * UC2 :- Ability to add a new Contact to Address Book
 *
 */

/**
 * import scanner class and arraylist class
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * create a main class name as AddressBookSystem
 */
public class AddressBookSystem{
    /**
     * create a array list object
     * The ArrayList class of the Java collections framework provides the functionality of resizable-arrays.
     * It implements the List interface.
     */
    ArrayList<Contacts> arrayDetails = new ArrayList<Contacts>();
    /**
     * The Scanner class is used to get user input, and it is found in the java.util package.
     * create a scanner class object
     */
    Scanner sc = new Scanner(System.in);

    /**
     * This method is used to add details to address book
     */
    public void addDetails() {
        /**
         * create a object an contacts class.
         * object name is info
         */
        Contacts info = new Contacts();

        System.out.println("Enter the first name");
        info.setFirstName(sc.nextLine());
        System.out.println("Enter the last name");
        info.setLastName(sc.nextLine());
        System.out.println("Enter the address");
        info.setAddress(sc.nextLine());
        System.out.println("Enter the city");
        info.setCity(sc.nextLine());
        System.out.println("Enter the state");
        info.setState(sc.nextLine());
        System.out.println("Enter the email");
        info.setEmail(sc.nextLine());
        System.out.println("Enter the zip code");
        info.setZip(sc.nextInt());
        System.out.println("Enter the phone number");
        info.setPhoneNumber(sc.nextLong());
        arrayDetails.add(info);
        sc.close();
    }

    /**
     * This method is used to display the added information
     */
    public void display() {
        System.out.println(arrayDetails);
    }

    /**
     * create a main method all program execute in main method
     * @param args no arguments
     */
    public static void main(String[] args) {
        /**
         * 1st print the welcome msg.
         */
        System.out.println("Welcome to Address Book Program");
        /**
         * create a object name as details for  AddressBookSystem  class
         * create object bcoz AddressBookSystem in this class all method is non static
         */
        AddressBookSystem details = new AddressBookSystem();
        /**
         * calling method to object name . method name
         * object name.method name;
         * object=details
         * method=addDetails(),display()
         */
        details.addDetails();
        details.display();
    }
}