class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(String msg){
        super(msg);
    }
}


public class Checking extends Account {

    public Checking(){
        super("Jhon", "Doe", "000-000-000", "UNKNOWN", -1, 0);
        this.isSaving = false;
    }

    public Checking(String first, String last, String ph_num,  String address, int acc_num, float bal){

        super(first, last, ph_num, address, acc_num, bal);

    }

    public void makeWithdrawal(){
        float val = getTransactionVal("Withdrawal");


        makeWithdrawal(val);
    }

    public void makeWithdrawal(float val){
        if (val > balance + 5000){
            return;
        }
        if( transactionsThisMonth() > 2 ){
            val += 10;
        }
        super.makeWithdrawal(val);
    }

    public void makeDeposit(){
        float val = getTransactionVal("Deposit");
        if( transactionsThisMonth() > 2 ){
            val -= 10;
        }
        super.makeDeposit(val);
    }

    public float calculateTax(){
        return (float) (0.005 * balance);
    }

    public void displayDeduction(){
        System.out.println("Account Holder " + first_name + " " + last_name);
        float cal_tax = calculateTax();
        System.out.println("Calculated Tax : " + calculateTax());
    }

    public int transactionsThisMonth(){
        // Checks How many withdrawals made this month
        return 0;
    }

    public float chargeDeductions(){

        if(balance <= 0){
            return 0;
        }

        float ret = calculateTax();
        balance -= ret;
        return ret;
    }

    public void displayDetails(){
        System.out.println("Account Type: Checking");
        super.displayDetails();
    }

}

