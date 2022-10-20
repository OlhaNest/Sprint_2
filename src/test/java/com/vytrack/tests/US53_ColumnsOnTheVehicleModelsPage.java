package com.vytrack.tests;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US53_ColumnsOnTheVehicleModelsPage{

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test (priority = 1)
    public void store_managers_see_10_columns() throws InterruptedException {

        WebElement usernameInputBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameInputBox.sendKeys("storemanager205");

        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInputBox.sendKeys("UserUser123");

        WebElement signBtn = driver.findElement(By.xpath("//button[@id='_submit']"));
        signBtn.click();

        // Select Fleet model
        WebElement fleetModule = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(fleetModule).perform();

        //Select Vehicles Model
        WebElement dropdown = driver.findElement(By.xpath("//span[.='Vehicles Model']"));
        Thread.sleep(2000);
        actions.moveToElement(dropdown).perform();

        //verify if store managers are able to see 10 columns
        WebElement tenColumns = driver.findElement(By.xpath("//table/thead[@class='grid-header']"));
        tenColumns.isDisplayed();
    }

    @Test (priority = 2)
    public void sales_managers_see_10_columns() throws InterruptedException {
        WebElement usernameInputBox2 = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameInputBox2.sendKeys("salesmanager144");

        WebElement passwordInputBox2 = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInputBox2.sendKeys("UserUser123");

        WebElement signBtn2 = driver.findElement(By.xpath("//button[@id='_submit']"));
        signBtn2.click();

        // Select Fleet model
        WebElement fleetModule2 = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        Actions actions2 = new Actions(driver);
        Thread.sleep(2000);
        actions2.moveToElement(fleetModule2).perform();

        //Select Vehicles Model
        WebElement dropdown2 = driver.findElement(By.xpath("//span[.='Vehicles Model']"));
        Thread.sleep(2000);
        actions2.moveToElement(dropdown2).perform();

        //verify if store managers are able to see 10 columns
        WebElement tenColumns2 = driver.findElement(By.xpath("//table/thead[@class='grid-header']"));
        tenColumns2.isDisplayed();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
