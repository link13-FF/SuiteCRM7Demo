package tests;

import dto.Contact;
import dto.ContactFactory;
import dto.User;
import org.testng.annotations.Test;
import base.BaseTest;

public class NewContactTest extends BaseTest {

    Contact contact = ContactFactory.getContact();

    @Test
    public void addNewContact() {
        loginStep.auth(User.will());
        ContactStep.addNewContact(contact);
    }
}
