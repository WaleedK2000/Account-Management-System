package com.company;

public class Main {

    public static void print(String val){
        System.out.println(val);
    }

    public static void main(String[] args) {
	// write your code here
        String p1 = "Hello\nbye!";
        int age = 5;
        System.out.println(age);
        print(p1);

        Account sav = new Saving();
        sav.makeWithdrawal();

        Account check = new Checking();
        check.makeWithdrawal();


    }
}
