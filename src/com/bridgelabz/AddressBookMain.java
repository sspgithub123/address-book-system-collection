package com.bridgelabz;

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
 * UC9 :- Ability to view Persons by City or State
 * UC10 :- Ability to get number of contact persons i.e. count by City or State
 * UC11 :- Ability to sort the entries in the address book alphabetically by Person’s name
 * UC12 :- Ability to sort the entries in the address book by City,State, or Zip
 * UC13 :- Ability to Read or Write the Address Book with  Persons Contact into a File using File IO
 *
 */

/**
 * import hashmap class
 * import iterator class
 * import map class
 * import scanner class
 * import set class
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


/**
 * create a class name as AddressBookMain
 */
public class AddressBookMain {
    /**
     * create a main method all program execute in main method
     * @param args no argument
     */
    public static void main(String[] args) {
        /**
         * create a scanner object
         */
        Scanner sc = new Scanner(System.in);
        /**
         * create a object for  AddressBookSystem class the object name as addressBook
         */
        AddressBookSystem addressBook = new AddressBookSystem();
        /**
         * create a object for map class object name is addressBookMap
         */
        Map<String, AddressBookSystem> addressBookMap = new HashMap<String, AddressBookSystem>();

        while (true) {
            /**
             * 1st display welcome msg
             * then display al the option
             */
            System.out.println("\nWelcome to Address Book System");

            System.out.println("1. New Address Book \n2. Select Address Book \n3. Delete Address Book \n4. Search Contact Data \n5.View Contact Data \n6.Count Contacts \n7. Exit");
            /**
             * choose the option what u want
             */
            System.out.print("Enter Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            /**
             * using switch case
             */
            switch (choice) {
                case 1:
                    System.out.println("Enter Name of new Address Book: ");
                    String bookName = sc.next();
                    sc.nextLine();
                    /**
                     * adding bookname as a key and value is allocating
                     * memory for addressbook object
                     */
                    addressBookMap.put(bookName, new AddressBookSystem());
                    /**
                     * call addressbookoption method with
                     * passing key of hashmap
                     */
                    AddressBookSystem.addressBookOptions(addressBookMap.get(bookName));
                    break;
                case 2:
                    System.out.println("List of available Address Book : ");
                    /**
                     * retrived keys from hashmap to show addressbooklist
                     */
                    Set<String> keys = addressBookMap.keySet();
                    Iterator<String> i = keys.iterator();
                    while (i.hasNext()) {
                        System.out.println(i.next());
                    }
                    /**
                     * choose the option which address book name u want to open
                     */
                    System.out.println("Enter Address Book name you want to Open : ");
                    String name = sc.nextLine();
                    /**
                     * display current address book name
                     */
                    System.out.println("Current Address Book is : " + name);
                    /**
                     * call method with passing address book name
                     */
                    AddressBookSystem.addressBookOptions(addressBookMap.get(name));
                    break;
                case 3:
                    /**
                     * display address book name to be deleted
                     */
                    System.out.println("Enter Address Book name to be delete: ");
                    name = sc.nextLine();
                    /**
                     * delete hashmap using remove function
                     */
                    addressBookMap.remove(name);
                    break;
                case 4:
                    /**
                     * display all the search options
                     */
                    System.out.println("Welcome to the search option:");
                    /**
                     * calling searchByOptions method from object name as addressBook
                     */
                    addressBook.searchByOptions();
                case 5:
                    /**
                     * display all the search options
                     */
                    System.out.println("Welcome to view By Option:");
                    /**
                     * calling viewByOption method from object name as addressBook
                     */
                    addressBook.viewByOption(addressBookMap);
                    break;
                case 6:
                    /**
                     * display welcome msg for counter
                     */
                    System.out.println("Welcome to the counter");
                    /**
                     * calling countByOption method from object name as addressBook
                     */
                    addressBook.countByOption();
                    break;
                case 7:
                    /**
                     * display welcome msg for soting data alphabetically
                     */
                    System.out.println("Welcome to the sorting data alphabetically");
                    /**
                     * calling sortByOption method from object name as addressBook
                     */
                    addressBook.sortByOption();
                case 8:
                    /**
                     * closing the scanner
                     */
                    sc.close();
                    return;
                /**
                 * if all the cases are false then execute default case
                 */
                default:
                    System.out.println("You Entered Invalid Choice....!");
                    break;
            }
        }
    }
}