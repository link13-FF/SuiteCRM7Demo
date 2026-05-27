package step;

import dto.Contact;
import org.openqa.selenium.WebDriver;
import pages.NewContactPage;

public class ContactStep {
    WebDriver driver;
    NewContactPage newContactPage;

    public ContactStep(WebDriver driver) {
        this.driver = driver;
        newContactPage = new NewContactPage(driver);
    }

    public NewContactPage addNewContact (Contact contact) {
        newContactPage.open()
                .isPageOpened()
                .addNewContact(contact)
                .pressSaveButton();
        return new NewContactPage(driver);
    }
}
