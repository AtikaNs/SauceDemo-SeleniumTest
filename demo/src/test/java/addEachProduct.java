import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import config.env_target;

public class addEachProduct extends env_target{
    @Before // setup before each test
    public void setUp(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\User\\Downloads\\SeleniumTest-SauceDemo\\demo\\src\\main\\resources\\msedgedriver.exe");     
        driver = new EdgeDriver(); // setting webdriver
        driver.manage().window().maximize(); // maximize window
        driver.get(baseUrl); // open baseUrl
        // login using valid credential
        driver.findElement(By.name("user-name")).sendKeys(vUser);
        driver.findElement(By.id("password")).sendKeys(vPass);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
    }

    @After // assert cart link after each test
    public void assertAddCart(){
        String expectedUrl = "https://www.saucedemo.com/v1/cart.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        driver.quit();
    }

    @Test // add item 0 to cart
    public void addProd0(){ 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("item_0_title_link")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("inventory_item_container"))
        );
        WebElement Result1 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='inventory_item_container']/div/div/div/button"))
        );
        System.out.println(Result1.getText());
        Result1.click();
        driver.findElement(By.id("shopping_cart_container")).click();
        WebElement Result2 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("contents_wrapper"))
        );
        System.out.println(Result2.getText());
    }

    @Test // add item 1 to cart
    public void addProd1(){ 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("item_1_title_link")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("inventory_item_container"))
        );
        WebElement Result1 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='inventory_item_container']/div/div/div/button"))
        );
        System.out.println(Result1.getText());
        Result1.click();
        driver.findElement(By.id("shopping_cart_container")).click();
        WebElement Result2 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("contents_wrapper"))
        );
        System.out.println(Result2.getText());
    }

    @Test // add item 2 to cart
    public void addProd2(){ 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("item_2_title_link")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("inventory_item_container"))
        );
        WebElement Result1 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='inventory_item_container']/div/div/div/button"))
        );
        System.out.println(Result1.getText());
        Result1.click();
        driver.findElement(By.id("shopping_cart_container")).click();
        WebElement Result2 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("contents_wrapper"))
        );
        System.out.println(Result2.getText());
    }

    @Test // add item 3 to cart
    public void addProd3(){ 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("item_3_title_link")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("inventory_item_container"))
        );
        WebElement Result1 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='inventory_item_container']/div/div/div/button"))
        );
        System.out.println(Result1.getText());
        Result1.click();
        driver.findElement(By.id("shopping_cart_container")).click();
        WebElement Result2 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("contents_wrapper"))
        );
        System.out.println(Result2.getText());
    }

    @Test // add item 4 to cart
    public void addProd4(){ 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("item_4_title_link")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("inventory_item_container"))
        );
        WebElement Result1 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='inventory_item_container']/div/div/div/button"))
        );
        System.out.println(Result1.getText());
        Result1.click();
        driver.findElement(By.id("shopping_cart_container")).click();
        WebElement Result2 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("contents_wrapper"))
        );
        System.out.println(Result2.getText());
    }

    @Test // add item 5 to cart
    public void addProd5(){ 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("item_5_title_link")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("inventory_item_container"))
        );
        WebElement Result1 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='inventory_item_container']/div/div/div/button"))
        );
        System.out.println(Result1.getText());
        Result1.click();
        driver.findElement(By.id("shopping_cart_container")).click();
        WebElement Result2 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("contents_wrapper"))
        );
        System.out.println(Result2.getText());
    }
}