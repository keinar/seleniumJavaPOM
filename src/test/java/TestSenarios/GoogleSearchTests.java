package TestSenarios;

import Objects.CommonPage;
import Objects.FacebookPage;
import Objects.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTests {

    WebDriver driver;
    public GoogleSearchPage googlePage;
    public FacebookPage fbPage;
    public CommonPage commonPage;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
        // Initialize page objects after creating the driver instance
        googlePage = new GoogleSearchPage(driver);
        fbPage = new FacebookPage(driver);
        commonPage = new CommonPage(driver);
    }

    @Test
    public void searchOperation() {
        googlePage.searchGoogle("facebook");
        googlePage.clickElement("[href=\"https://www.facebook.com/login/\"]");
        commonPage.validatePageTitle("Digital Solution");
        fbPage.loginOperation("0526865357", "password!!");
    }

    @Test
    public void searchOperation2() throws Exception {
        googlePage.searchGoogle("digital solution");
        googlePage.clickElement("[href='https://digital-solution.co.il/']");
        commonPage.validatePageTitle("Digital Solution");
        commonPage.scrollToElementView("[data-id=\"100c748\"]");
        commonPage.takeSnapShot(driver,"D:/javaSelenium/src/test/SnapShots/test.png");

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
