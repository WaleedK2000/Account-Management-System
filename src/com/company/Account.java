package com.company;


//This Class Manages Account Functions
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

    public void makeWithdrawal(){
        System.out.println("how are ya?");
    }

    public float getBalance(){
        return balance;
    }

    public String getFirst_name(){
        return first_name;
    }

    public String getLast_name(){
        return last_name;
    }

    public int getPhone_num(){
        return account_num;
    }

    public String getAddress(){
        return address;
    }

}
