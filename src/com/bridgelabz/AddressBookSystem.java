package com.bridgelabz;
/**
 * Program on User Registration Using Regex
 *
 * @author : Shubham Pawar
 * @since : 04/04/2022
 * */
/**
 /**
 * UC1 :- Ability to create a Contacts in Address Book with first and last names, address,
 *        city, state, zip, phone number and email...
 * UC2 :- Ability to add a new Contact to Address Book
 * UC3 :- Ability to edit existing contact person using their name
 * UC4 :- Ability to delete a person using person's name
 * UC5 :- Ability to add multiple person to Address Book
 * UC6 :- Refactor to add multiple Address Book to the System Each Address Book has a unique Name
 * UC7 :- Ability to ensure there is no Duplicate Entry of the same Person in a particular Address Book
 * UC8 :- Ability to search Person in a City or State across the multiple AddressBook
 */

/**
 * import scanner class and arraylist class, collectors and list
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/**
 * create a class name as AddressBookSystem
 */
public class AddressBookSystem {
    /**
     * create a arraylist object name as contactList
     * Store the person all details in object
     */
    public ArrayList<Contacts> contactList = new ArrayList<>();

    /**
     * create a method name as addContact,this is parameterized method
     * this method is boolean type that means their output is true or false
     *
     * @param contact in contactlist
     * @return true
     */
    public boolean addContact(Contacts contact) {
        List<Contacts> checkByName = searchByName(contact.getFirstName());
        for (Contacts equalName : checkByName)
            if (equalName.equals(contact))
                return false;
        contactList.add(contact);
        return true;
    }

    /**
     * create a method name as searchByName this is parametrized method
     *
     * @param name of person in contactlist
     * @return search name
     */
    public List<Contacts> searchByName(String name) {
        /**
         * collection list of element
         * stream and lambda for find filter given name from arraylist
         */
        return contactList.stream().filter(person -> person.getFirstName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    /**
     * create a method name as searchByCity in this method we search the pesron is their city name
     *
     * @param city person
     * @return person
     */
    public List<Contacts> searchByCity(String city) {
        return contactList.stream().filter(person -> person.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    /**
     * create a method name as searchByState in this method we search the person is their State name
     *
     * @param state person
     * @return person
     */
    public List<Contacts> searchByState(String state) {
        return contactList.stream().filter(person -> person.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    /**
     * create a method name as editContact this is parameterized method
     *
     * @param current details
     * @param edit    edit the what u want
     * @return editing new data
     */
    public boolean editContact(Contacts current, Contacts edit) {
        /**
         * if condition is true then return false
         */
        if (!contactList.contains(current))
            return false;
        /**
         * remove current data in contactlist
         */
        contactList.remove(current);
        /**
         * add the newly data in contactList
         */
        contactList.add(edit);
        /**
         * both are ture then return true
         */
        return true;
    }

    /**
     * create a method for delete contact, this is parameterized method
     *
     * @param contacts in contactlist
     * @return delete contact
     */
    public boolean deleteContact(Contacts contacts) {
        /**
         * delete the contact in contactList
         */
        contactList.remove(contacts);
        return true;
    }

    /**
     * for showing output details
     *
     * @return result
     */
    @Override
    public String toString() {
        /**
         * if contact list is empty then return no contacts found
         */
        if (contactList.isEmpty())
            return "No contacts found!";
        String result = new String();
        /**
         * using for loop check the condition and search the contactList in specific position
         * then update
         */
        for (int i = 0; i < contactList.size(); i++) {
            result += " " + contactList.get(i);
        }
        return result;
    }

    /**
     * create a method name as readContact
     * method for adding details
     *
     * @return firstName, lastName, email, phoneNumber, City, Address, Zip, State
     */
    public static Contacts readContact() {
        /**
         * create a scanner class object
         * scanner is used for geeting input from user
         */
        Scanner sc = new Scanner(System.in);
        /**
         * user input for first name in string type
         */
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        /**
         * user input for last name in string type
         */
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
        /**
         * user input for address in string type
         */
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        /**
         * user input for city in string type
         */
        System.out.print("Enter City: ");
        String city = sc.nextLine();
        /**
         * user input for state in string type
         */
        System.out.print("Enter State: ");
        String state = sc.nextLine();
        /**
         * user input for Zip in integer type
         */
        System.out.print("Enter Zip Code: ");
        int zip = sc.nextInt();
        sc.nextLine();
        /**
         * user input for phone number in long type
         */
        System.out.print("Enter Phone Number: ");
        Long phoneNumber = sc.nextLong();
        sc.nextLine();
        /**
         * user input for Email Id in string type
         */
        System.out.print("Enter Email ID: ");
        String email = sc.nextLine();
        /**
         * return new contacts
         */
        return new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
    }

    /**
     * create a method name as addressBookOptions
     * method for show option for contacts
     *
     * @param addressBook show contacts
     */
    public static void addressBookOptions(AddressBookSystem addressBook) {
        /**
         * create object for scanner class
         */
        Scanner sc = new Scanner(System.in);
        while (true) {
            /**
             * chosse option for what u want
             */
            System.out.println("\n-------------------------- Address Book Contact Option --------------------------");
            System.out.println("1. Add contact details");
            System.out.println("2. Edit contact details");
            System.out.println("3. Delete contact details");
            System.out.println("4. Show contacts details");
            System.out.println("5. Back to main menu");
            System.out.print("Enter Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    /**
                     * call addcontact with passing method readcontact
                     */
                    if (addressBook.addContact(readContact()))
                        System.out.println("Contact Added Successfully....!");
                    else
                        System.out.println("Contact Already Exist....!");
                    break;
                case 2:
                    System.out.println("Enter First name to edit contact: ");
                    String name = sc.nextLine();
                    /**
                     * list of equal first name
                     */
                    List<Contacts> equalName = addressBook.searchByName(name);
                    /**
                     * if not match found
                     */
                    if (equalName.isEmpty())
                        System.out.println("Data Not Found....!");
                    /**
                     * if only one equal match found
                     */
                    else if (equalName.size() == 1) {
                        /**
                         * call edit method with name and method
                         */
                        addressBook.editContact(equalName.get(0), readContact());
                        /**
                         * parameter
                         */
                        System.out.println("Contact data modified....!");
                    } else {
                        /**
                         * if more than one firstname match found in equal name list
                         */
                        equalName.forEach(x -> System.out.println(equalName.indexOf(x) + "  " + x.toString()));
                        System.out.println("Enter index to edit : ");
                        int i = sc.nextInt();
                        sc.nextLine();
                        addressBook.editContact(equalName.get(i), readContact());
                        System.out.println("Contact Modified....!");
                    }
                    break;
                case 3:
                    System.out.println("Enter First name to delete contact: ");
                    name = sc.nextLine();
                    equalName = addressBook.searchByName(name);
                    if (equalName.isEmpty())
                        System.out.println("Data Not Found.....!");
                    else if (equalName.size() == 1) {
                        addressBook.deleteContact(equalName.get(0));
                        System.out.println("Contact data deleted....!");
                    } else {
                        equalName.forEach(x -> System.out.println(equalName.indexOf(x) + "  " + x.toString()));
                        System.out.println("Enter an index to delete");
                        int index = sc.nextInt();
                        sc.nextLine();
                        addressBook.deleteContact(equalName.get(index));
                        System.out.println("Contact data deleted....!");
                    }
                    break;
                case 4:
                    /**
                     * call tostring method for showing details
                     */
                    System.out.println(addressBook.toString());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
    }
    /**
     * create a method name as searchByOptions
     */
    public void searchByOptions() {
        /**
         * create object for  AddressBookSystem class,object name is addressBook
         */
        AddressBookSystem addressBook = new AddressBookSystem();
        /**
         * create object for scanner class
         */
        Scanner sc = new Scanner(System.in);
        /**
         * choose option
         */
        System.out.println("1. By name");
        System.out.println("2. By city");
        System.out.println("3. By state");
        System.out.println("4. Back");
        System.out.println("Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        /**
         * using switch case in this case search the person is their city or state
         */
        switch (choice) {
            case 1:
                System.out.println("Enter name: ");
                String name = sc.nextLine();
                contactList.forEach(book -> searchByName(name).forEach(System.out::println));
                break;
            case 2:
                System.out.println("Enter city: ");
                String city = sc.nextLine();
                contactList.forEach(book -> searchByCity(city).forEach(System.out::println));
                break;
            case 3:
                System.out.println("Enter state: ");
                String state = sc.nextLine();
                contactList.forEach(book -> searchByState(state).forEach(System.out::println));
                break;
            case 4:
                return;
            default:
                System.out.println("INVALID CHOICE!");
        }
    }
}