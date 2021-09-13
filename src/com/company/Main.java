package com.company;

import java.util.*;

public class Main {

    static LinkedList<Account> account_list;
    static float interestRate = 2;

    private static void menu_A(){

        boolean exit = false;
        while (!exit){
            System.out.println("0 ... To Exit");
            System.out.println("1 ... Open a New Account");
            System.out.println("2 ... Login to an Account");
            System.out.println("3 ... Change Interest Rate");


            Scanner scan = new Scanner(System.in);
            int input = scan.nextInt();

            while(input <0 || input > 3){
                System.out.println("Invalid Input ... Please Try again");
                input = scan.nextInt();
            }

            System.out.println("Your choice");
            System.out.println(input);

            switch(input){
                case 0:
                    exit = true;
                    break;
                case 1:
                    addNewAccount();
                    break;
                case 2:
                    loginAccount();
                    break;
                case 3:
                    modifyInterestRate();
                    break;
            }
        }


    }

    private static void loginAccount(){

        System.out.println("Enter Account Number");
        int a = account_list.size();

        System.out.println("Enter Next Value");
        Scanner scan = new Scanner(System.in);
        int acc_num = scan.nextInt();

        if(acc_num > a || acc_num < 1){
            System.out.println("Invalid account num \n");
            return;
        }
        else{
            System.out.println("--- Valid Account --- \n");
            Account acc = account_list.get(acc_num);
            System.out.println("1 ... Make Deposit");
            System.out.println("2 ... Make Withdrawal");
            System.out.println("3 ... Transfer Money");
            System.out.println("4 ... Calculate Zakat");
            System.out.println("5 ... Display Deduction");

            Scanner red = new Scanner(System.in);
            int choice = red.nextInt();

            while(choice > 5 || choice< 1 ){
                System.out.println("Try Again! ");
                choice = red.nextInt();
            }

        }

    }

    private static void addNewAccount(){

        int new_acc_num = account_list.size()+1;
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------NEW ACCOUNT-----------");

        System.out.println("Enter First Name");
        String first_name = scan.next();

        System.out.println("Enter Last Name");
        String last_name = scan.next();

        System.out.println("Enter Address");
        String address = scan.next();

        System.out.println("Enter Phone Number");
        String phone_num = scan.next();

        System.out.println("Press 1 if you want to create a savings account");
        int acc_type = scan.nextInt();

        if(acc_type == 1){
            account_list.add(new Saving(first_name,last_name,phone_num,address, new_acc_num,0));
        }
        else{
            account_list.add(new Checking(first_name,last_name,phone_num,address, new_acc_num,0));
        }
        System.out.println("\n");

    }

    private static void modifyInterestRate(){
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
