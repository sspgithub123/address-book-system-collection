package com.bridgelabz;
/**
 * Program on User Registration Using Regex
 *
 * @author : Shubham Pawar
 * @since : 04/04/2022
 * */
/**
 /**
 /**
 * UC1 :- Ability to create a Contacts in Address Book with first and last names, address,
 *        city, state, zip, phone number and email...
 * UC2 :- Ability to add a new Contact to Address Book
 * UC3 :- Ability to edit existing contact person using their name
 * UC4 :- Ability to delete a person using person's name
 * UC5 :- Ability to add multiple person to Address Book
 * UC6 :- Refactor to add multiple Address Book to the System Each Address Book has a unique Name
 *
 */

/**
 * import scanner class and arraylist class
 */

import java.util.ArrayList;
import java.util.HashMap;
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
    static Scanner sc = new Scanner(System.in);

    static HashMap<String, ArrayList<Contacts>> hashmap = new HashMap<>();
    static AddressBookSystem details = new AddressBookSystem();
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
//        sc.close();
    }
    /**
     *This method is used to edit the details in address book
     */

    public void display(){
        System.out.println(arrayDetails);
    }

    /**
     * create a method name as editDetails.
     * This method is used to edit the details in address book
     */

    public void editDetails() {
        System.out.println("Confirm your first name to edit details: ");
        String confirmName = sc.next();
        /**
         * using for loop
         * a)i=0=initialize; b)i < arrayDetails.size()=condition; c)i++= increment by 1
         *
         * 1) 1st initialize the value of a variable,then check the condition,then go to if condiion,in this condition arrayDetails object
         *   the element at the specified position in this list then if they are equals then select the option
         *   choose edit detatils then 1st confirm ur first name to edit details then put ur previous name what u set this,
         *   then select what u want change,suppose u choose first name,
         *   then put it new name what u want then its edit and after the print all the information with editing new name
         *   then again update.
         *
         */
        for (int i = 0; i < arrayDetails.size(); i++) {
            if (arrayDetails.get(i).getFirstName().equals(confirmName)) {
                System.out.println("Select form below to change: ");
                System.out.println("\n1.First Name\n2.Last Name\n3.Address\n4.city\n5.State\n6.Zip\n7.Mobile number\n8.Email");
                int edit = sc.nextInt();
                // sc.close();

                /**
                 * switch case is used for what u want edit
                 */
                switch (edit) {
                    case 1:
                        System.out.println("Enter first name");
                        arrayDetails.get(i).setFirstName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter Last name");
                        arrayDetails.get(i).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter Address");
                        arrayDetails.get(i).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter City");
                        arrayDetails.get(i).setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter State");
                        arrayDetails.get(i).setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter Zip");
                        arrayDetails.get(i).setZip(sc.nextInt());
                        break;
                    case 7:
                        System.out.println("Enter Mobile number");
                        arrayDetails.get(i).setPhoneNumber(sc.nextLong());
                        break;
                    case 8:
                        System.out.println("Enter new E-mail");
                        arrayDetails.get(i).setEmail(sc.next());
                        break;
                }
                /**
                 * if you will check the name which you have written earlier,whether it matches or not ,
                 * if it matches then it will be edited after that.
                 * if  you put previous name is incorrect then show the else statement
                 */
                System.out.println("Edited list is: ");
                System.out.println(arrayDetails);
            } else
                System.out.println("Enter a valid First name");
        }

    }
    /**
     * create a method name as deleteDetails
     * This method is used to delete the contact details
     */
    public void deleteDetails() {
        System.out.println("Confirm the first name of the person to delete contact");
        //user input
        String confirmName = sc.next();
        /**
         * using for loop
         * 1) 1st initialize the value of a variable,then check the condition,then go to if condition,in this condition arrayDetails object
         *   the element at the specified position check in object then check they are equal or not if condtion is true then delete the element
         *   in arrayDetails
         */
        for (int i = 0; i < arrayDetails.size(); i++) {

            if (arrayDetails.get(i).getFirstName().equals(confirmName)) {
                arrayDetails.remove(i);
                System.out.println("List After removing"+arrayDetails);

                /**
                 * if condition is false then print enter valid first name
                 */
            } else {
                System.out.println("Enter valid first name");
            }
        }
    }

    /**
     * create a method name as createAddressBook
     */
    public void createAddressBook() {

        while (true) {
            /**
             * 1st choose the option what u want
             */
            System.out.println("Choose what you want to do: ");
            System.out.println("1.Create new address book.\n2.Edit existing address book.\n3.Display all address books.\n4.exit");
            int choose = sc.nextInt();
            /**
             * if you choose option 4 then exist in process
             */
            if (choose == 4) {
                System.out.println("Exited");
                break;
            }

            /**
             * if u choose option 1 create new address book
             * then enter the name of address book
             */
            switch (choose) {
                case 1:
                    System.out.println("Enter the name of address book: ");
                    String address_name = sc.next();

                    /**
                     * condition to check for uniqueness of address book.
                     */
                    if (hashmap.containsKey(address_name)) {
                        System.out.println("Adress book name exits, enter different name");
                        break;
                    }
                    /**
                     * create a array list object name as new_address_book
                     */
                    ArrayList<Contacts> new_address_book = new ArrayList<>();
                    /**
                     * here arrayDetails is the 1st object and new_address_book is 2nd but both are storing all details
                     */
                    arrayDetails = new_address_book;
                    while (true) {
                        /**
                         * choose what u want to do
                         * if u choose add details then all details put it like first name ,
                         * last name,email,zip,mobile no,city,state,address etc
                         * if you choice 5 then exit in all process
                         */
                        System.out.println("Choose what you want to do: ");
                        System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact. \n4.Display Contact\n5.Exit");
                        int choose1 = sc.nextInt();
                        if (choose1 == 4) {
                            System.out.println("Exited");
                            break;
                        }
                        /**
                         * using switch case
                         * in the switch case we are calling the method
                         */
                        switch (choose1) {
                            case 1:
                                details.addDetails();
                                break;
                            case 2:
                                details.editDetails();
                                break;
                            case 3:
                                details.deleteDetails();
                                break;
                            case 4:
                                details.display();
                                break;
                            default:
                                System.out.println("Choose valid option");
                                break;
                        }
                        hashmap.put(address_name, arrayDetails);
                        System.out.println(hashmap);
                    }
                    break;

                case 2:
                    System.out.println("Enter the name of address book: ");
                    String address_name_old = sc.next();

                    /**
                     * condition to check whether address book exists or no.
                     */
                    if (hashmap.containsKey(address_name_old)) {
                        /**
                         * create a array list object name as old_address_book
                         */
                        ArrayList<Contacts> old_address_book = new ArrayList<>();
                        /**
                         * arrayDetails is 1st object in store all the data
                         * now here all the data store in old address book
                         */
                        arrayDetails = old_address_book;
                        arrayDetails = hashmap.get(address_name_old);
                        while (true) {
                            /**
                             * choose the option what u want
                             */
                            System.out.println("Choose what you want to do: ");
                            System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact. \n4.Display contact.\n5.Exit");
                            int choose1 = sc.nextInt();
                            if (choose1 == 4) {
                                System.out.println("Exited");
                                break;
                            }
                            /**
                             * switch case is used
                             * in this switch case we are calling those method
                             * if choose option 1 add contact then calling this method in switch case
                             */
                            switch (choose1) {
                                case 1:
                                    details.addDetails();
                                    break;
                                case 2:
                                    details.addDetails();
                                    break;
                                case 3:
                                    details.addDetails();
                                    break;
                                case 4:
                                    details.display();
                                    break;
                                default:
                                    System.out.println("Choose valid option");
                                    break;
                            }
                            hashmap.put(address_name_old, arrayDetails);
                            System.out.println(hashmap);
                        }
                        /**
                         *
                         */
                    } else {
                        System.out.println("Enter valid address book name");
                    }
                    break;

                case 3:
                    System.out.println(hashmap);
                    break;

                default:
                    System.out.println("Enter valid option");

            }
        }
    }

    /**
     * create a main method all program execute in main method
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 1st print the welcome msg
         */
        System.out.println("Welcome to Address Book Program");
        /**
         * calling method
         * calling method = object name.method name
         * here object is details and method is createAddressBook()
         */
        details.createAddressBook();
    }
}