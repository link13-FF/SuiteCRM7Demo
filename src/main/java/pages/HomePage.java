package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By HOME_TITLE = By.xpath("//div[@id='about_header']/h1");
    private final By ABOUT_SITE_ELEMENT = By.cssSelector("div.about_suite:nth-of-type(2) > h3");
    private final String HOME_URL = "index.php?module=Home&action=Demo";

    @Override
    public HomePage isPageOpened() {
        //log.info("Page '{}' opening check", MAIN_URL + PAGE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_TITLE));
        return this;
    }

    @Override
    public HomePage open() {
        //log.info("Page '{}' opening", MAIN_URL + PAGE_URL);
        driver.get(BASE_URL + HOME_URL);
        return this;
    }
}