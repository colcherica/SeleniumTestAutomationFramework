package com.herokuapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Base {
public static WebDriver driver;

static long startTime = System.currentTimeMillis();
static long endTime = System.currentTimeMillis();

    @BeforeAll
    public static void initialize() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        System.out.printf("Run started at time " + startTime);
        driver = new ChromeDriver();
        String URL = "http://the-internet.herokuapp.com/login";
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("Run ended at time " + endTime);
        driver.quit();
    }
}
