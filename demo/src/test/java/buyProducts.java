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

public class buyProducts extends env_target{
    @Before // set up before each test
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\SeleniumTest-SauceDemo\\demo\\src\\main\\resources\\chromedriver.exe");     
        driver = new ChromeDriver(); // setting webdriver
        driver.manage().window().maximize(); // maximize window
        driver.get(baseUrl); // open baseUrl
        // login using valid credential
        driver.findElement(By.name("user-name")).sendKeys(vUser);
        driver.findElement(By.id("password")).sendKeys(vPass);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
    }

    @After //checkout products after each test
    public void checkOut(){
        // checkout product
        driver.findElement(By.xpath("//*[@id='cart_contents_container']/div/div[2]/a[2]")).click();
        System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/div[2]")).getText());
        // input name and postal code
        driver.findElement(By.id("first-name")).sendKeys(fname);
        driver.findElement(By.id("last-name")).sendKeys(lname);
        driver.findElement(By.id("postal-code")).sendKeys(zipcode);
        assert2();
        // checkout overview page
        driver.findElement(By.xpath("//*[@id=\'checkout_info_container\']/div/form/div[2]/input")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id='contents_wrapper']/div[2]")).getText());
        assert3();
        // make an order (automatically paid)
        driver.findElement(By.xpath("//*[@id=\'checkout_summary_container\']/div/div[2]/div[8]/a[2]")).click();
        System.out.println(driver.findElement(By.id("contents_wrapper")).getText());
        driver.quit();
    }

    @Test // buy Product 1
    public void buyP1(){ 
        System.out.println("Checkout Products 1");
        acP1(); // add Product 1 to cart
        seeCart(); // see product in cart 
        shyc();
        npaP1(); // assert Product 1 name
        assert1(); // assert cart's link
    }

    @Test // buy Product 3 and 6
    public void buyP36(){ 
        System.out.println("Checkout Products 3 & 6");
        acP3(); // add Product 3 to cart
        acP6(); // add Product 6 to cart
        seeCart(); // see product in cart 
        shyc();
        npaP3(); // assert 1st product name
        npaP6(); // assert 2nd product name
        assert1(); // assert cart's link
    }

    @Test // add Product 1-4, then remove Product 2
    public void buyP13(){ 
        System.out.println("Add Products 1-4. But, only checkout Products 1 & 3");
        acP1(); // add Product 1 to cart
        acP2(); // add Product 2 to cart
        acP3(); // add Product 3 to cart
        acP4(); // add Product 4 to cart
        acP4(); // undo add Product 4 to cart
        seeCart(); // see product in cart 
        shyc(); // show subheader your cart text
        dcP2(); // remove Product 2 from cart
        npaP1(); // assert product 1's name
        npaP3(); // assert product 3's name
        assert1(); // assert cart's link
    }

    @Test // Add Products 2-6. But, only checkout Products 2, 4, & 6
    public void buyP246(){ 
        System.out.println("Add Products 2-6. But, only checkout Products 2, 4, & 6");
        acP2(); // add Product 2 to cart
        acP3(); // add Product 3 to cart
        acP4(); // add Product 4 to cart
        acP3(); // undo add Product 3 cart
        acP5(); // add Product 3 to cart
        acP5(); // undo add Product 5 to cart
        acP6(); // add Product 6 to cart
        seeCart(); // see product in cart 
        shyc(); // show subheader your cart text
        npaP2(); // assert Product 2 name
        npaP4(); // assert Product 4 name
        npaP6(); // assert Product 6 name
        assert1(); // assert cart's link
    }

    @Test // add Product 1-6, then remove all
    public void buyNothing(){ 
        System.out.println("Add all products, then checkout nothing");
        acP2(); // add Product 2 to cart
        acP3(); // add Product 3 to cart
        acP1(); // add Product 1 to cart
        acP4(); // add Product 4 to cart
        acP5(); // add Product 5 to cart
        acP6(); // add Product 6 to cart
        seeCart(); // see product in cart 
        shyc(); // show subheader your cart text
        for(int i = 0; i < 6; i++){
            WebElement remove = driver.findElement(By.xpath("//button[normalize-space()='REMOVE']"));
            Boolean removeExist = remove.isDisplayed(); 
            if(removeExist == true){
                remove.click();
            }
        }
        //findElement
        assert1(); // assert cart's link
    }

    @Test // Add Products 1, 2, 4, 5. But, only checkout Products 1 & 5
    public void buyP15(){ 
        System.out.println("Add Products 1, 2, 4, 5. But, only checkout Products 1 & 5");
        acP1(); // add Product 1 to cart
        acP4(); // add Product 4 to cart
        acP4(); // undo add Product 4 to cart
        acP5(); // add Product 5 to cart
        acP6(); // add Product 6 to cart
        seeCart(); // see product in cart 
        shyc(); // show subheader your cart text
        dcP2(); // remove Product 2 from cart
        npaP1(); // assert Product 1 name
        npaP5(); // assert Product 5 name
        assert1(); // assert cart's link
    }    

    // Add to Cart, P = Product
    // If want to undo before check the product's list in the cart, use the method twice
    public void acP1(){
        driver.findElement(By.xpath("//*[@id=\'inventory_container\']/div/div[1]/div[3]/button")).click();
    }

    public void acP2(){
        driver.findElement(By.xpath("//*[@id=\'inventory_container\']/div/div[2]/div[3]/button")).click();
    }

    public void acP3(){
        driver.findElement(By.xpath("//*[@id=\'inventory_container\']/div/div[3]/div[3]/button")).click();
    }

    public void acP4(){
        driver.findElement(By.xpath("//*[@id=\'inventory_container\']/div/div[4]/div[3]/button")).click();
    }

    public void acP5(){
        driver.findElement(By.xpath("//*[@id=\'inventory_container\']/div/div[5]/div[3]/button")).click();
    }

    public void acP6(){
        driver.findElement(By.xpath("//*[@id=\'inventory_container\']/div/div[6]/div[3]/button")).click();
    }

    // delete from product's list in the cart, P = Product no in the cart
    public void dcP2(){
        driver.findElement(By.xpath("//*[@id=\'cart_contents_container\']/div/div[1]/div[4]/div[2]/div[2]/button")).click();
    }

    // product's name and , then assert product's name
    // npa = name, , assert; P = product in the cart
    public void npaP1(){
        WebElement Result = driver.findElement(By.id("item_4_title_link"));
        System.out.println(Result.getText());
        Assert.assertEquals(Result.getText(), "Sauce Labs Backpack");
    }

    public void npaP2(){
        WebElement Result = driver.findElement(By.id("item_0_title_link"));
        System.out.println(Result.getText());
        Assert.assertEquals(Result.getText(), "Sauce Labs Bike Light");
    } 

    public void npaP3(){
        WebElement Result = driver.findElement(By.id("item_1_title_link"));
        System.out.println(Result.getText());
        Assert.assertEquals(Result.getText(), "Sauce Labs Bolt T-Shirt");
    }
 
    public void npaP4(){
        WebElement Result = driver.findElement(By.id("item_5_title_link"));
        System.out.println(Result.getText());
        Assert.assertEquals(Result.getText(), "Sauce Labs Fleece Jacket");
    }

    public void npaP5(){
        WebElement Result = driver.findElement(By.id("item_2_title_link"));
        System.out.println(Result.getText());
        Assert.assertEquals(Result.getText(), "Sauce Labs Onesie");
    }

    public void npaP6(){
        WebElement Result = driver.findElement(By.id("item_3_title_link"));
        System.out.println(Result.getText());
        Assert.assertEquals(Result.getText(), "Test.allTheThings() T-Shirt (Red)");
    }

    // product's list in the cart
    public void seeCart(){
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    // assert cart's link
    public void assert1(){
        String expectedUrl = "https://www.saucedemo.com/v1/cart.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    // assert your information link
    public void assert2(){
        String expectedUrl = "https://www.saucedemo.com/v1/checkout-step-one.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    // assert checkout overview link
    public void assert3(){
        String expectedUrl = "https://www.saucedemo.com/v1/checkout-step-two.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    // assert check out complete link
    public void assert4(){
        String expectedUrl = "https://www.saucedemo.com/v1/checkout-complete.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    // Show subheader your cart display text
    public void shyc(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Result = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='contents_wrapper']/div[2]"))
        );
        System.out.println(Result.getText());
    }
}