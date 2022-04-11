package com.bridgelabz;

/**
 * import all class in io package
 * import hashmap class
 * import map class
 */

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * create a class name as FileIO
 */
public class FileIO {
    /**
     * create a method name as writeData
     * @param addressBook store all details
     */
    public void writeData(Map<String, AddressBookMain> addressBook) {
        File file = new File("C:\\Users\\admin\\Desktop\\java\\Day27ADDRESSBOOK\\Java_Day27_AddressBookSystem_FileIO\\src\\com\\day27\\AddressBookSystem.java");
        BufferedWriter bw = null;
        /**
         * using try and catch block for exception handling
         */
        try {
            /**
             * create new BufferedWriter for the output file
             */
            bw = new BufferedWriter(new FileWriter(file));

            /**
             * iterate map entries
             */
            for (Map.Entry<String, AddressBookMain> entry : addressBook.entrySet()) {
                /**
                 * put key and value separated by a colon
                 */
                bw.write(entry.getKey() + ":" + entry.getValue());

                /**
                 * new line
                 */
                bw.newLine();
            }
            bw.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * create a method name as map
     * public List<Contacts> readData() {
     * @return map file content
     */
    public static Map<String,  String> readData() {
        /**
         * create a object name as mapFileContents
         */
        Map<String, String> mapFileContents = new HashMap<>();
        BufferedReader br = null;
        /**
         * using try catch block for exception handling
         */
        try {
            /**
             * create file object
             */
            File file = new File("Address Book.txt");

            /**
             * create BufferedReader object from the File
             */
            br = new BufferedReader(new FileReader(file));

            String line = null;
            /**
             * read file line by line
             */
            while ((line = br.readLine()) != null) {

                /**
                 * split the line by :
                 */
                String[] parts = line.split(":");
                String bookName = parts[0].trim();
                String fname = parts[1].trim();
                mapFileContents.put(bookName, fname);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**
             * Always close the BufferedReader
             */
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
        }
        return mapFileContents;
    }
}