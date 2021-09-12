package com.company;

import java.util.*;

public class Main {

    static LinkedList<Account> account_list;
    static float interestRate = 2;

    private static void menu_A(){
        System.out.println("0 ... To Exit");
        System.out.println("1 ... Open a New Account");
        System.out.println("2 ... Login to an Account");
        System.out.println("3 ... Change Interest Rate");


        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        while(input <1 || input > 3){
            System.out.println("Invalid Input ... Please Try again");
            input = scan.nextInt();
        }

        System.out.println("Your choice");
        System.out.println(input);



    }

    void modifyInterestRate(){
        Scanner scan = new Scanner(System.in);
        interestRate = scan.nextFloat();

        while (interestRate < 0 || interestRate > 1) {
            System.out.println("Invalid .. Please Try again ");
            interestRate = scan.nextFloat();
        }
        System.out.println("Interest Rate Set to " );
        System.out.println(interestRate);
        System.out.println("\n");
    }

    public static void print(String val){
        System.out.println(val);
    }

    public static void main(String[] args) {
	// write your code here
        String p1 = "Hello\nbye!";



        account_list = new LinkedList<Account>();
        account_list.add(new Checking("Waleed", "Kayani", "050132850", "Rawalpindi, Pakistan", 1, 100000));

        menu_A();


    }
}
