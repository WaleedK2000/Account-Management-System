import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//This Class Manages Account Functions
public class Account {
    String first_name;
    String last_name;
    String phone_num;
    String address;
    Date acc_created;
    int account_num;
    float balance;
    boolean isSaving;

    public void displayDetails(){
        System.out.println("Name: " + first_name + " " + last_name);
        System.out.println("Address: " + address);
        System.out.println("Account num: "+account_num);
        System.out.println("Balance " + balance + " PKR");
    }

    public Account (String first, String last, String ph_num,  String address, int acc_num, float bal){

        if(bal < 0){
            throw new InsufficientFundsException("Balance Cannot be negative when opening a new account");
        }
        else if (bal == 0){
            throw new InsufficientFundsException("Balance Cannot be 0 when opening a new account");
        }
        else{
            acc_created = new Date(2021,Calendar.SEPTEMBER,12);
            setAll(first, last, ph_num, address, acc_num, bal);
            this.isSaving=false;
        }


    }

    public void setAll(String first, String last, String ph_num,  String address, int acc_num, float bal){
        this.first_name = first;
        this.last_name = last;
        this.phone_num = ph_num;
        this.address = address;
        this.account_num = acc_num;
        this.balance = bal;
    }


    public void checkBalance(){
        System.out.println("Account Holder: "+first_name + ' ' + last_name + '\n');
        System.out.println("Balance: " + balance + " PKR\n" );
    }

    protected void makeWithdrawal(float with_amt){

        if( with_amt > 0){
            balance -= with_amt;
        }

    }

    public void makeDeposit(float a){

        if( a > 0){
            balance += a;
        }

    }

    public void makeDeposit(){

    }

    public void makeWithdrawal(){

    }

    public void printStatement(){
        checkBalance();
    }

    public void transferAmount(Account other, float amt){
        this.makeWithdrawal(amt);
        other.makeDeposit(amt);

    }

   public void displayDeduction(){

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

    public boolean isSavingAcc(){
        return isSaving;
    }

    public int getPhone_num(){
        return account_num;
    }



    public String getAddress(){
        return address;
    }

    public void setFirst_name(String first_name){
        this.first_name=first_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    public void setPhone_num(String phone_num){
        this.phone_num = phone_num;
    }

    protected float getTransactionVal(String type){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n _____________________________________ \n");
        System.out.println("Transaction Request \n");
        System.out.println("TYPE : ");
        System.out.println(type);
        //System.out.println("\n");
        System.out.println("Please Enter Desired Amount : ");
        return  scan.nextFloat();
    }

    public float chargeDeductions(){
        return 0;
    }
    public void displayBalance(){
        System.out.println("Account Holder: " + first_name + " " + last_name + " \n");
        System.out.println("Balance: " + balance);
    }


}


