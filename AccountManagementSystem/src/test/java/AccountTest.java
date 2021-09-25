import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AccountTest {

    
    Account test_account;
    private Object InsufficientFundsException;

    @Before
    public void setUp() throws Exception {
        test_account = new Checking("Jhon", "Doe", "01233456", "NULL", 1, 10000);
    }

    @Test
    public void checkBalanceFunc(){
        float i = 10000;
        System.out.println(test_account.getBalance());

        assertEquals(test_account.getBalance(),i,0.0);
    }

    @Test
    public void testWithdrawalPositive(){
        test_account.makeWithdrawal(2500);
        assertEquals(test_account.getBalance(), 7500,0.0 );
    }

    @Test
    public void testWithdrawalNegative(){
        test_account.makeWithdrawal(-2500);
        assertEquals(test_account.getBalance(), 10000, 0.0    );
    }

    @Test
    public void testWithdrawalOverdraftChecking(){
        assertEquals(10000,test_account.getBalance(),0.0);
        test_account.makeWithdrawal(11000);
        assertEquals( -1000,test_account.getBalance(), 0.0);
        test_account.makeWithdrawal(11000);
        assertEquals( -1000, test_account.getBalance(), 0.0);
    }
    @Test
    public void testWithdrawalOverdraftCheckingNegative(){
        float initial_val = test_account.getBalance();
        test_account.makeWithdrawal(20000);
        assertEquals( initial_val, test_account.getBalance(), 0.0);
    }

    @Test
    public void makeDepositTest(){
        assertEquals(10000 , test_account.getBalance(),0.0);
        test_account.makeDeposit(25);
        test_account.makeDeposit(-25);
        assertEquals(10025 , test_account.getBalance(),0.0);
    }
    @Test
    public void makeDepositTestNegative(){
        assertEquals(10000 , test_account.getBalance(),0.0);
        test_account.makeDeposit(-25);
        assertEquals(10000 , test_account.getBalance(),0.0);
    }

    @Test
    public void chargeDeductionTest(){
        test_account.chargeDeductions();
        assertEquals(9950, test_account.getBalance(),0.0);
    }

    @Test
    public void chargeDeductionTestWhenBalanceZero(){

        test_account.makeWithdrawal(10000);
        test_account.chargeDeductions();
        assertEquals(0, test_account.getBalance(),0.0);
    }

    @Test(expected = RuntimeException.class)
    public void testInitialBalance0(){
        test_account = new Checking("Jhon", "Doe", "01233456", "NULL", 1, 0);
    }

    @Test(expected = RuntimeException.class)
    public void testInitialBalanceNegative(){
        test_account = new Checking("Jhon", "Doe", "01233456", "NULL", 1, -1000);
    }

}