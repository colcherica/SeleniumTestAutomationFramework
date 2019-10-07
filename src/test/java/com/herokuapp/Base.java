package com.herokuapp;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Base {

protected static WebDriver driver;

    @BeforeTest
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        String URL = "http://the-internet.herokuapp.com/login";
        driver.get(URL);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterTest
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
