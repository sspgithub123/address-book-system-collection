package com.bridgelabz;
/**
 * import all class in java util package
 * import collectors class
 * import function class
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

/**
 * create a class name as AddressBookSystem
 */
public class AddressBookSystem {
    /**
     * create a arraylist object name as contactList
     * Store the person all details in object
     */
    public static ArrayList<Contact> contactList = new ArrayList<>();

    /**
     * create a object for map,object name is nameHashMap
     * store persons name in this object
     */
    public static Map<String, Contact> nameHashMap = new HashMap<String, Contact>();
    /**
     * create a object for map,object name is nameHashMap
     * store the city of person in this object
     */
    public static Map<String, Contact> cityHashMap = new HashMap<String, Contact>();
    /**
     * create a object for map,object name is StateHashMap
     * store the State of person in this object
     */
    public static Map<String, Contact> stateHashMap = new HashMap<String, Contact>();
    /**
     *  creating scanner class object
     *  scanner class used to taking input form user
     */
    static Scanner sc = new Scanner(System.in);
    /**
     * creating an object for AddressBookSystem class object name as addressBook
     */
    static AddressBookSystem addressBook = new AddressBookSystem();

    /**
     * create a method name as addContact,this is parameterized method
     * this method is boolean type that means their output is true or false
     * @param contact in contactlist
     * @return true
     */
    public boolean addContact(Contact contact) {
        List<Contact> checkByName = searchByName(contact.getFirstName());
        for (Contact equalName : checkByName)
            if (equalName.equals(contact))
                return false;
        contactList.add(contact);
        return true;
    }

    /**
     * create a method name as searchByName this is parametrized method
     * @param name of person in contactlist
     * @return search name
     */
    public List<Contact> searchByName(String name) {
        /**
         * collection list of element
         * stream and lambda for find filter given name from arraylist
         */
        return contactList.stream().filter(person -> person.getFirstName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    /**
     * create a method name as searchByCity in this method we search the pesron is their city name
     * @param city person
     * @return person
     */
    public List<Contact> searchByCity(String city) {
        /**
         * collection list of element
         * stream and lambda for find filter given city from arraylist
         */
        return contactList.stream().filter(person -> person.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    /**
     * create a method name as searchByState in this method we search the person is their State name
     * @param state person
     * @return person
     */
    public List<Contact> searchByState(String state) {
        /**
         * collection list of element
         * stream and lambda for find filter given State from arraylist
         */
        return contactList.stream().filter(person -> person.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    /**
     * Method to view person by name
     * @param nameHashMap persons name
     */
    public static void viewByName(Map<String, Contact> nameHashMap) {
        nameHashMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "=" + e.getValue().toString()));
    }

    /**
     * Method to view person by city
     * @param cityHashMap persons city
     */
    public static void viewByCity(Map<String, Contact> cityHashMap) {
        cityHashMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "=" + e.getValue().toString()));
    }

    /**
     * Method to view person by state
     * @param stateHashMap persons state
     */
    public static void viewByState(Map<String, Contact> stateHashMap) {
        stateHashMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "=" + e.getValue().toString()));
    }

    /**
     * creating sortby method for sorting the data
     */
    public static List<Contact> sortBy(Function<? super Contact, ? extends String> key) {
        /**
         * in contactList sorted the data and comapring with key and collect to the previous result in list
         */
        return contactList.stream().sorted(Comparator.comparing(key)).collect(Collectors.toList());
    }
    /**
     * creating sortbyZip method for sorting the data by perons zip code
     */
    public static List<Contact> sortByZip(Function<? super Contact, ? extends Long> key) {
        /**
         * in contactList sorted the data and comapring with key and collect to the previous result in list
         */
        return contactList.stream().sorted(Comparator.comparing(key)).collect(Collectors.toList());
    }
    /**
     * creating sortByName method for sorting the data by perons Name
     */
    public static List<Contact> sortByName(Function<? super Contact, ? extends String> key) {
        /**
         * in contactList sorted the data and comapring with key and collect to the previous result in list
         */
        return contactList.stream().sorted(Comparator.comparing(key)).collect(Collectors.toList());
    }

    /**
     * create a method name as editContact this is parameterized method
     * @param current details
     * @param edit edit the what u want
     * @return editing new data
     */
    public boolean editContact(Contact current, Contact edit) {
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
     * @param contacts in contactlist
     * @return delete contact
     */
    public boolean deleteContact(Contact contacts) {
        /**
         * delete the contact in contactList
         */
        contactList.remove(contacts);
        return true;
    }

    /**
     * for showing output details
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
     * @return firstName,lastName,email,phoneNumber,City,Address,Zip,State
     */
    public static Contact readContact() {
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
        return new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
    }

    /**
     * create a method name as addressBookOptions
     * method for show option for contacts
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
                    /**
                     *  create a new contact check in address book this contact duplicate or not
                     *  they are not duplicate then display this msg
                     */
                        System.out.println("Contact Added Successfully....!");
                    /**
                     * if duplicate contact present in address book then print this msg
                     */
                    else
                        System.out.println("Contact Already Exist....!");
                    break;
                case 2:
                    /**
                     * if u want edit ur 1st name then enter the first name in contact
                     */
                    System.out.println("Enter First name to edit contact: ");
                    String name = sc.nextLine();
                    /**
                     * list of equal first name
                     */
                    List<Contact> equalName = addressBook.searchByName(name);
                    /**
                     * if not match found
                     */
                    if (equalName.isEmpty())
                    /**
                     * match not fount then display data not found msg
                     */
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
                /**
                 * suppose all cases are false then execute default case
                 */
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

    /**
     * create a method name as viewByOption this is parameterized method.
     * this method for view element by option
     * @param addressBookMap
     */
    public static void viewByOption(Map<String, AddressBookSystem> addressBookMap) {
        /**
         * create a object for scanner class
         */
        Scanner sc = new Scanner(System.in);
        /**
         * show this option
         */
        System.out.println("1. View By name");
        System.out.println("2. View By city");
        System.out.println("3. View By state");
        System.out.println("4. Back");
        /**
         * enter ur choice what u want
         */
        System.out.print("Enter Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        /**
         * using switch case
         */
        switch (choice) {
            case 1:
                viewByName(nameHashMap);
                break;
            case 2:
                viewByCity(cityHashMap);
                break;
            case 3:
                viewByState(stateHashMap);
                break;
            case 4:
                return;
            default:
                System.out.println("INVALID CHOICE!");
        }
    }

    /**
     * create a method name as countByOption
     * this method to count element by option
     */
    public void countByOption() {
        /**
         * create a scanner class object
         */
        Scanner sc = new Scanner(System.in);
        /**
         * display all this options
         */
        System.out.println("1. Count City ");
        System.out.println("2. Count State");
        System.out.println("3. Back ");
        /**
         * choice ur option what u want
         */
        System.out.println("Enter Your Choice : ");
        int choice = sc.nextInt();
        sc.nextLine();
        /**
         * using switch case
         */
        switch (choice) {
            case 1:
                /**
                 * Map<String, Long>  countCity  – this is the output result
                 * Map that will store the grouped elements as keys and count their occurrences as values,
                 * contactList.stream() – we convert the contactlist elements into Java stream to
                 * process the collection in a declarative way
                 * Collectors.groupingBy() – this is the method of Collectors class to
                 * group objects by some property and store results in a Map instance
                 * Collectors.counting() – this Collectors class method counts the number
                 * of elements passed in the stream as a parameter
                 */
                Map<String, Long> countCity = contactList.stream()
                        .collect(Collectors.groupingBy(e -> e.getCity(), Collectors.counting()));
                System.out.println(countCity + "\n");
                break;
            case 2:
                Map<String, Long> countState = contactList.stream()
                        .collect(Collectors.groupingBy(e -> e.getState(), Collectors.counting()));
                System.out.println(countState + "\n");
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid Option");
        }
    }

    /**
     * create a method name as sortByOption
     */
    public void sortByOption() {
        /**
         * display this options
         */
        System.out.println("1. By first name");
        System.out.println("2. By last name");
        System.out.println("3. By city");
        System.out.println("4. By state");
        System.out.println("5. By zip");
        System.out.println("6. Back");
        /**
         * choose the option what u want
         */
        System.out.print("Your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                AddressBookSystem.sortBy(Contact::getFirstName).forEach(System.out::println);
                break;
            case 2:
                AddressBookSystem.sortBy(Contact::getLastName).forEach(System.out::println);
                break;
            case 3:
                AddressBookSystem.sortBy(Contact::getCity).forEach(System.out::println);
                break;
            case 4:
                AddressBookSystem.sortBy(Contact::getState).forEach(System.out::println);
                break;
            case 5:
                return;
            default:
                System.out.println("INVALID CHOICE!");
        }
    }
}