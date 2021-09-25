import com.company.Saving;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class SavingTest{

    Saving test_account;

    @Before
    public void setUp() throws Exception {
        test_account = new Saving("Waleed", "Khalid", "000-000-000", "UNKNOWN", 1,3000);
    }

    @Test
    public void firstNameTest(){
        assertEquals("Waleed", test_account.getFirst_name());
    }

    public void lastNameTest(){
        assertEquals("Khalid", test_account.getLast_name());
    }


    @Test
    public void calculateIntrestTest() {
        assertEquals(3000 ,test_account.calculateIntrest(1),0.0);
    }

    @Test
    public void testChargeDeductions() {
        float expected_bal = 6000;
        test_account.chargeDeductions();
        assertEquals(expected_bal,test_account.getBalance());
    }

    @Test
    public void testChargeDeductionsWithHugeBalance() {
        test_account.makeDeposit(80000);
        assertEquals(83000,test_account.getBalance(),0.0);
        float expected_bal = 163925;
        test_account.chargeDeductions();
        assertEquals(expected_bal,test_account.getBalance());
    }

    @Test
    public void testMakeWithdrawalOverdraft() {
        float expected_bal = 3000;
        test_account.makeWithdrawal(90000);
        assertEquals(expected_bal,test_account.getBalance());
    }

    @Test
    public void testMakeWithdrawal() {
        float expected_bal = 2000;
        test_account.makeWithdrawal(1000);
        assertEquals(expected_bal,test_account.getBalance());
    }

    @Test
    public void testMakeDeposit() {
        float expected_bal = 6000;
        test_account.makeDeposit(3000);
        assertEquals(expected_bal,test_account.getBalance());
    }

    @Test
    public void testMakeDepositNegative() {
        float expected_bal = 3000;
        test_account.makeDeposit(-3000);
        assertEquals(expected_bal,test_account.getBalance());
    }

    @Test
    public void testMakeWithdrwalNegative() {
        float expected_bal = 3000;
        test_account.makeWithdrawal(-3000);
        assertEquals(expected_bal,test_account.getBalance());
    }

}