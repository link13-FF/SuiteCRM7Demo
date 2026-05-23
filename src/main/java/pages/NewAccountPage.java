package pages;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.AddressInput;
import wrappers.AddressTextArea;
import wrappers.Dropdown;
import wrappers.Input;

@Log4j2
public class NewAccountPage extends BasePage{

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    private final By SAVE_BUTTON = By.id("SAVE");
    private final String NEW_ACCOUNT_URL = "index.php?module=Accounts&action=EditView&return_module=Accounts&" +
            "return_action=DetailView";

    @Override
    public NewAccountPage open() {
        log.info("Page '{}' opening", BASE_URL + NEW_ACCOUNT_URL);
        driver.get(BASE_URL + NEW_ACCOUNT_URL);
        return this;
    }

    @Override
    public NewAccountPage isPageOpened() {
        log.info("Page '{}' opening check", BASE_URL + NEW_ACCOUNT_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
        return this;
    }

    @Step ("Заполнение нового аккаунта")
    public NewAccountPage addNewAccount(Account account) {
        log.info("Adding new account with name: '{}'", account.getName());
        new Input(driver, "Name").write(account.getName());
        new Input(driver, "Office Phone").write(account.getOfficePhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());
        new AddressTextArea(driver, "Billing Address", "Street").
                write(account.getBillingAddressStreet());
        new AddressTextArea(driver, "Shipping Address", "Street").
                write(account.getShippingAddressStreet());
        new Dropdown(driver, "Type").select(account.getDropdown());
        new AddressInput(driver, "Billing Address", "City").write(account.getBillingAddressCity());
        new AddressInput(driver, "Billing Address", "State/Region").
                write(account.getBillingAddressState());
        new AddressInput(driver, "Billing Address", "State/Region").
                write(account.getBillingAddressPostalCode());
        new AddressInput(driver, "Billing Address", "State/Region").
                write(account.getBillingAddressCountry());
        new AddressInput(driver, "Shipping Address", "City").write(account.getShippingAddressCity());
        new AddressInput(driver, "Shipping Address", "State/Region").
                write(account.getShippingAddressState());
        new AddressInput(driver, "Billing Address", "State/Region").
                write(account.getShippingAddressPostalCode());
        new AddressInput(driver, "Billing Address", "State/Region").
                write(account.getBillingAddressCountry());
        new Dropdown(driver, "Type").select(account.getType());
        new Dropdown(driver, "Industry").select(account.getIndustry());
        return new NewAccountPage(driver);
    }

    @Step ("Нажатие на кнопку 'Save'")
    public NewAccountPage pressSaveButton () {
        WebElement saveButton = driver.findElement(SAVE_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
        return new NewAccountPage(driver);
    }
}
