import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.env_target;

public class Login extends env_target {
    @Test // blank username & pass
    public void blankForm(){
        // set driver location path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\SeleniumTest-SauceDemo\\demo\\src\\main\\resources\\chromedriver.exe");
        // maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // set URL
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]"))
        );
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/h3"))
        );
        driver.quit();
    };

    @Test // blank pass
    public void blankPass(){
        // set driver location path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\SeleniumTest-SauceDemo\\demo\\src\\main\\resources\\chromedriver.exe");
        // maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // set URL
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]"))
        );
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/h3"))
        );
        driver.quit();
    };

    @Test
    public void invalidUname(){
        // set driver location path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\SeleniumTest-SauceDemo\\demo\\src\\main\\resources\\chromedriver.exe");
        // maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // set URL
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]"))
        );
        driver.findElement(By.name("user-name")).sendKeys("standard_sauce");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/h3"))
        );
        driver.quit();
    };

    @Test
    public void invalidPass(){
        // set driver location path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\SeleniumTest-SauceDemo\\demo\\src\\main\\resources\\chromedriver.exe");
        // maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // set URL
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]"))
        );
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_saucy");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/h3"))
        );
        driver.quit();
    };

    @Test
    public void validLogin(){
        // set driver location path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\SeleniumTest-SauceDemo\\demo\\src\\main\\resources\\chromedriver.exe");
        // maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // set URL
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]"))
        );
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/div"))
        );
        driver.quit();
    };
};
