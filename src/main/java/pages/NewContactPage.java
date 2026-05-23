package pages;

import dto.Contact;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.AddressInput;
import wrappers.AddressTextArea;
import wrappers.Input;

@Log4j2
public class NewContactPage extends BasePage {

    public NewContactPage(WebDriver driver) {
        super(driver);
    }

    private final By SAVE_BUTTON = By.id("SAVE");
    private final String NEW_CONTACT_URL = "/index.php?module=Contacts&action=EditView&return_module=" +
            "Contacts&return_action=DetailView";

    @Override
    public NewContactPage open() {
        log.info("Page '{}' opening", BASE_URL + NEW_CONTACT_URL);
        driver.get(BASE_URL + NEW_CONTACT_URL);
        return this;
    }

    @Override
    public NewContactPage isPageOpened() {
        log.info("Page '{}' opening check", BASE_URL + NEW_CONTACT_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
        return this;
    }

    @Step("Заполнение нового Контакта")
    public NewContactPage addNewContact(Contact contact) {
        log.info("Adding new contact with lastname: '{}'", contact.getLastName());
        new Input(driver, "First Name").write(contact.getFirstName());
        new Input(driver, "Last Name").write(contact.getLastName());
        new Input(driver, "Office Phone").write(contact.getOfficePhone());
        new Input(driver, "Job Title").write(contact.getJobTitle());
        new Input(driver, "Mobile").write(contact.getMobile());
        new Input(driver, "Department").write(contact.getDepartment());
        new Input(driver, "Fax").write(contact.getFax());
        new AddressTextArea(driver, "Primary Address", "Address").write(contact.getPrimaryAddress());
        new AddressInput(driver, "Primary Address", "City").write(contact.getPrimaryCity());
        new AddressInput(driver, "Primary Address", "State/Region").write(contact.getPrimaryState());
        new AddressInput(driver, "Primary Address", "Postal Code").
                write(contact.getPrimaryPostalCode());
        new AddressInput(driver, "Primary Address", "Country").write(contact.getPrimaryCountry());
        new AddressTextArea(driver, "Other Address", "Address").write(contact.getOtherAddress());
        new AddressInput(driver, "Other Address", "City").write(contact.getOtherCity());
        new AddressInput(driver, "Other Address", "State/Region").write(contact.getOtherState());
        new AddressInput(driver, "Other Address", "Postal Code").write(contact.getOtherPostalCode());
        new AddressInput(driver, "Other Address", "Country").write(contact.getOtherCountry());
        return new NewContactPage(driver);
    }


    @Step("Нажатие на кнопку 'Save'")
    public NewContactPage pressSaveButton() {
        WebElement saveButton = driver.findElement(SAVE_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
        return new NewContactPage(driver);
    }
}
