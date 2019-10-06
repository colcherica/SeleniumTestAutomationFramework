package com.herokuapp.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;

public class LoginPage {

     WebDriver driver;

//    constructor page
    public LoginPage ( WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * All WebElements are identified by @FindBy annotation
     */
//    Locators

    @FindBy(how = How.ID, using = "username")
    WebElement userName;
    @FindBy(how = How.ID, using = "password")
    WebElement password;
    @FindBy(how = How.XPATH,using = ".//button[contains(@type, 'submit')]")
    WebElement loginBtn;
    @FindBy(how = How.TAG_NAME, using = "h2")
    WebElement textTitlePage;
    @FindBy(how = How.TAG_NAME, using = "h4")
    WebElement textContentPage;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'flash error')]")
    WebElement invalidPassword;
   @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'flash error')]")
    WebElement invalidUserName;


    public void setUserName( String strUserName){
        userName.sendKeys(strUserName);
    }

    public void setPassword(String srtPassword){
        password.sendKeys(srtPassword);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public void isPageOpened(){
        textTitlePage.getText();
        if (textTitlePage.isDisplayed()){
            System.out.println("Title is present " + textTitlePage.getText() + "\n");
        }else {
            System.out.println("Title is not present " + textTitlePage.getText());
        }
    }

    public void isPageContentAvailable(){
        textContentPage.getText();
    }

    public void errorPasswordMsg() {
        invalidPassword.getText();

    }

    public void errorUserNameMsg(){
       invalidUserName.getText();
        if (invalidUserName.isDisplayed()){
            System.out.println("Error message for invalid username is present : " + invalidUserName.getText());
        }else {
            System.out.println("Error message for invalid username is not present : " + invalidUserName.getText());
        }
    }

    public void loginToInternet( String strUserName, String srtPassword) {
        this.setUserName(strUserName);
        this.setPassword(srtPassword);
        this.clickLoginBtn();
    }

    public void getRespondsCode ( String actualUrl) throws IOException {
        URL url = new URL(actualUrl);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int code  = connection.getResponseCode();
        if (code == HttpURLConnection.HTTP_OK){
            System.out.print(" Code is: " + code + " " + true);
        }else {
            System.out.print("Code is: " + code + " " + false);
        }

    }


}
