package pages;

import dto.User;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By USERNAME_FIELD = By.id("user_name");
    private final By PASSWORD_FIELD = By.id("username_password");
    private final By LOGIN_BUTTON = By.name("Login");
    private final String LOGIN_URL = "index.php?module=Users&action=Login";

    @Override
    public LoginPage isPageOpened() {
        log.info("Page '{}' opening check", BASE_URL + LOGIN_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    @Override
    @Step ("Открытие страницы Login Page")
    public LoginPage open() {
        log.info("Page '{}' opening", BASE_URL + LOGIN_URL);
        driver.get(BASE_URL + LOGIN_URL);
        return this;
    }

    @Step("Авторизация")
    public HomePage login(User user) {
        log.info("Login with credential '{}', '{}'", user.login(), user.password());
        driver.get("https://demo.suiteondemand.com/index.php?module=Users&action=Login");
        isPageOpened();
        driver.findElement(USERNAME_FIELD).sendKeys(user.login());
        driver.findElement(PASSWORD_FIELD).sendKeys(user.password());
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }
}