package com.company;

public class Saving extends Account {

    public Saving(){
        super("Jhon", "Doe", "000-000-000", "UNKNOWN", -1, 0);
        this.isSaving = true;
    }

    public Saving(String first, String last, String ph_num,  String address, int acc_num, float bal){
        super(first, last, ph_num, address, acc_num, bal);
        this.isSaving=true;
    }

    private float calculateZakat(){
        if(balance >= 20000 ){
            return (float) (balance * 0.025);
        }
        else{
            return 0;
        }
    }


    public void makeWithdrawal(){
       float val = getTransactionVal("Withdrawal");
       makeWithdrawal(val);
    }

    public float calculateIntrest( float rate ){
        return rate * balance;
    }

    public void displayDeduction(){
        System.out.println("Account Holder " + first_name + " " + last_name);
        float cal_zakat =calculateZakat();
        System.out.println("Calculated Zakat : " + cal_zakat);
    }

    public void chargeDeductions(){
        balance -= calculateZakat();
        balance += calculateIntrest(balance);
    }

    public void displayDetails(){
        System.out.println("Account Type: Saving");
        super.displayDetails();
    }

}
