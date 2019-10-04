package com.herokuapp.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage ( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'flash success')]")
    WebElement loginSuccessMsg;

    @FindBy(how = How.TAG_NAME, using = "h2")
    WebElement titlePage;

    @FindBy(how = How.XPATH, using = "//*[@id=\'content\']/div/a/i")
    WebElement logoutBtn;




    public boolean successMsg(){
        System.out.println(loginSuccessMsg.getText() + " \n");
        return loginSuccessMsg.getText().contains("You logged into a secure area!");
    }

    public boolean isTitlePageavailable(){
        System.out.println(titlePage.getText() + " \n");
        return titlePage.getText().contains(" Secure Area");
    }

    public void clickLogoutBtn(){
        logoutBtn.click();
    }
}
