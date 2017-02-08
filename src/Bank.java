/**
 * Created Feb 2, 2017 by Wes Messamore for Day 4 Homework Assignment at The Iron Yard
 * This is a dynamic program for an ATM that uses HashMap to keep track of bank accounts.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    static Scanner scanner = new Scanner(System.in);
    static Scanner scannerdouble = new Scanner(System.in);
    static Map<String, Double> accounts = new HashMap();

    static void initializeData(){
        accounts.put("Ragnar", 100.00);
        accounts.put("Henry", 45.00);
        accounts.put("John", 99.00);
    }

    public static void main(String[] args) throws Exception {

        initializeData();

        System.out.println("Thank You for using Java Bank!");

        User user = new User();

        user.chooseName();
        user.chooseOption();




    }


}