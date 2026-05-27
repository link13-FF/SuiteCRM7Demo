package tests;
import dto.Account;
import dto.AccountFactory;
import dto.User;
import base.BaseTest;
import org.testng.annotations.Test;


public class NewAccountTest extends BaseTest {

    Account account = new Account("",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "Investor",
            "Banking");

    Account account2 = AccountFactory.getAccount("Investor", "Banking");

    @Test
    public void addNewAccount() {
        loginStep.auth(User.will());
        newAccountStep.addNewAccount(account2);
    }




}
