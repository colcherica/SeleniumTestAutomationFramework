package com.herokuapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Base {

public static WebDriver driver;

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        String URL = "http://the-internet.herokuapp.com/login";
        driver.get(URL);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
