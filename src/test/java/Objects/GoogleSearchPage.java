package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {

    WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.cssSelector("[type=\"search\"]");

    public void searchGoogle(String searchVal) {
        driver.findElement(searchBox).sendKeys(searchVal);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }

    public void clickElement(String btnLocator) {
        driver.findElement(By.cssSelector(btnLocator)).click();
    }


}
