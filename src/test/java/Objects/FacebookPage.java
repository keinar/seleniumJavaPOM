package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FacebookPage {

    WebDriver driver;

    public FacebookPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginOperation(String userName, String password) {
        driver.findElement(By.cssSelector("[id='email']")).sendKeys(userName);
        driver.findElement(By.cssSelector("[id='pass']")).sendKeys(password);
        driver.findElement(By.cssSelector("[id='pass']")).sendKeys(Keys.ENTER);

    }
}
