package step;

import dto.Account;
import org.openqa.selenium.WebDriver;
import pages.NewAccountPage;

public class NewAccountStep {
    WebDriver driver;
    NewAccountPage newAccountPage;

    public NewAccountStep(WebDriver driver) {
        this.driver = driver;
        newAccountPage = new NewAccountPage(driver);
    }

    public NewAccountPage addNewAccount (Account account) {
        newAccountPage.open()
                .isPageOpened()
                .addNewAccount(account)
                .pressSaveButton();
        return new NewAccountPage(driver);
    }
}