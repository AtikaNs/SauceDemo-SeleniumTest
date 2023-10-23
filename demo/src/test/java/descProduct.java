import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import config.env_target;

public class descProduct extends env_target{
    @Before // setup before each test
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\SeleniumTest-SauceDemo\\demo\\src\\main\\resources\\chromedriver.exe");     
        driver = new ChromeDriver(); // setting webdriver
        driver.manage().window().maximize(); // maximize window
        driver.get(baseUrl); // open baseUrl
        // login using valid credential
        driver.findElement(By.name("user-name")).sendKeys(vUser);
        driver.findElement(By.id("password")).sendKeys(vPass);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='inventory_filter_container']/div"))
        );
        System.out.println(firstResult.getText());
    }

    @After // quit driver
    public void close(){
        driver.quit();
    }

    @Test // see item 0 description
    public void descProd0(){ 
        driver.findElement(By.xpath("//*[@id='item_0_title_link']")).click();
        WebElement Result = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(
            ExpectedConditions.visibilityOfElementLocated(By.id("inventory_item_container"))
        );
        System.out.println(Result.getText());
        String expectedUrl = "https://www.saucedemo.com/v1/inventory-item.html?id=0";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);    
    }

    @Test // see item 1 description
    public void descProd1(){ 
        driver.findElement(By.xpath("//*[@id='item_1_title_link']")).click();
        WebElement Result = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(
            ExpectedConditions.visibilityOfElementLocated(By.id("inventory_item_container"))
        );
        System.out.println(Result.getText());
        String expectedUrl = "https://www.saucedemo.com/v1/inventory-item.html?id=1";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);    
    }

    @Test // see item 2 description
    public void descProd2(){ 
        driver.findElement(By.xpath("//*[@id='item_2_title_link']")).click();
        WebElement Result = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(
            ExpectedConditions.visibilityOfElementLocated(By.id("inventory_item_container"))
        );
        System.out.println(Result.getText());
        String expectedUrl = "https://www.saucedemo.com/v1/inventory-item.html?id=2";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);    
    }

    @Test // see item 3 description
    public void descProd3(){ 
        driver.findElement(By.xpath("//*[@id='item_3_title_link']")).click();
        WebElement Result = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(
            ExpectedConditions.visibilityOfElementLocated(By.id("inventory_item_container"))
        );
        System.out.println(Result.getText());
        String expectedUrl = "https://www.saucedemo.com/v1/inventory-item.html?id=3";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);    
    }
    
    @Test // see item 4 description
    public void descProd4(){ 
        driver.findElement(By.xpath("//*[@id='item_4_title_link']")).click();
        WebElement Result = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(
            ExpectedConditions.visibilityOfElementLocated(By.id("inventory_item_container"))
        );
        System.out.println(Result.getText());
        String expectedUrl = "https://www.saucedemo.com/v1/inventory-item.html?id=4";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);    
    }

    @Test // see item 5 description
    public void descProd5(){ 
        driver.findElement(By.xpath("//*[@id='item_5_title_link']")).click();
        WebElement Result = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(
            ExpectedConditions.visibilityOfElementLocated(By.id("inventory_item_container"))
        );
        System.out.println(Result.getText());
        String expectedUrl = "https://www.saucedemo.com/v1/inventory-item.html?id=5";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);    
    }
}