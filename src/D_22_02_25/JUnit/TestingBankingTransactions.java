package D_22_02_25.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class TestingBankingTransactions {
    static class BankAccount {
        private double balance;
        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }
        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }
        public double getBalance() {
            return balance;
        }
    }
    private BankAccount account;
    @BeforeEach
    void setUp() {
        account = new BankAccount(100.0);
    }
    @Test
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }
    @Test
    void testWithdrawSuccess() {
        assertTrue(account.withdraw(40.0));
        assertEquals(60.0, account.getBalance());
    }
    @Test
    void testWithdrawFailureDueToInsufficientFunds() {
        assertFalse(account.withdraw(200.0));
        assertEquals(100.0, account.getBalance());
    }
    @Test
    void testWithdrawFailureDueToNegativeAmount() {
        assertFalse(account.withdraw(-20.0));
        assertEquals(100.0, account.getBalance());
    }
}
