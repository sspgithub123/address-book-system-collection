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
 * UC3 :- Ability to edit existing contact person using their name
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
    static Scanner sc = new Scanner(System.in);

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
                sc.close();

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
     * create a main method all program execute in main method
     * @param args no arguments
     */
    public static void main(String[] args) {
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

        int i = 0;
        while (i == 0) {
            /**
             * 1st print the welcome msg.
             */
            System.out.println("Welcome to Address Book Program");
            System.out.println("What do you want to do: ");
            System.out.println("1.Add details.\n2.Edit details.");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    details.addDetails();
                    break;
                case 2:
                    details.editDetails();
                    break;
                default:
                    i = 1;
                    System.out.println("Wrong option");
                    break;
            }
        }

    }
}