package omgtu.lecturevisitor;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class WebDriverController{
    private final String lastName;
    private final String firstNameGroup;
    private String url;
    WebDriverController(String lastName, String firstName, String group){
        this.lastName = lastName;
        this.firstNameGroup = firstName + " " + group;
    }
    void setUrl(String url){
        this.url = url;
    }

    void startBrowsing() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(this.url);

        Thread.sleep(1000);
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Введите фамилия']"));
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='Введите имя']"));
        WebElement button = driver.findElement(By.xpath("//button[@color='success']"));

        lastName.sendKeys(this.lastName);
        firstName.sendKeys(this.firstNameGroup);
        Thread.sleep(1000);
        button.click();
        Thread.sleep(5000);

        WebElement secButton = driver.findElement(By.xpath("//button[@color='success']"));
        secButton.click();
    }
}