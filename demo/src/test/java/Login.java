import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import config.env_target;

public class Login extends env_target {
    @Before // setup before each test
    public void information(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\SeleniumTest-SauceDemo\\demo\\src\\main\\resources\\chromedriver.exe");     
        driver = new ChromeDriver(); // setting webdriver
        driver.manage().window().maximize(); // maximize window
        driver.get(baseUrl); // open baseUrl
    }

    @After // close driver
    public void close(){
        driver.quit();
    }

    @Test // valid credentials login test
    public void validLogin(){ 
        driver.findElement(By.name("user-name")).sendKeys(vUser);
        driver.findElement(By.id("password")).sendKeys(vPass);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
        String expectedUrl = "https://www.saucedemo.com/v1/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
    
    @Test // blank username & pass
    public void blankForm(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]"))
        );
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/h3"))
        );
    };

    @Test // blank pass
    public void blankPass(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]"))
        );
        driver.findElement(By.name("user-name")).sendKeys(vUser);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/h3"))
        );
    };

    @Test // in valid username login test
    public void invalidUname(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]"))
        );
        driver.findElement(By.name("user-name")).sendKeys("standard_sauce");
        driver.findElement(By.id("password")).sendKeys(vPass);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/h3"))
        );
    };

    @Test // invalid pass login test
    public void invalidPass(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]"))
        );
        driver.findElement(By.name("user-name")).sendKeys(vUser);
        driver.findElement(By.id("password")).sendKeys("secret_saucy");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/h3"))
        );
    };

    @Test // login using locked out user
    public void lockedUser(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]"))
        );
        driver.findElement(By.name("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys(vPass);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/h3"))
        );
    };

    @Test // login using problem user (image not displayed)
    public void problemUser(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]"))
        );
        driver.findElement(By.name("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys(vPass);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[1]"))
        );
    }
};