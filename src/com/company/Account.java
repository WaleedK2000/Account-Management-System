package com.company;



public class Account {
    String first_name;
    String last_name;
    String phone_num;
    String address;
    int account_num;
    float balance;

    public void checkBalance(){
        System.out.println("Account Holder: "+first_name + ' ' + last_name + '\n');
        System.out.println("Balance" + balance + " PKR\n" );
    }

}
