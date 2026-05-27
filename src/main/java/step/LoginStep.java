package step;

import dto.User;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;

    public LoginStep (WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    public HomePage auth(User user) {
        loginPage.open()
                .isPageOpened()
                .login(user)
                .isPageOpened();
        return new HomePage(driver);
    }
}
