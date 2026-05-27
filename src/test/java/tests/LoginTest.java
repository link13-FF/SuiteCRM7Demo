package tests;
import dto.User;
import base.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
         loginStep.auth(user, password);
    }
}
