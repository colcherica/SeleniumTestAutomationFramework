package com.herokuapp.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage ( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'flash success')]")
    WebElement loginSuccessMsg;

    @FindBy(how = How.TAG_NAME, using = "h2")
    WebElement titlePage;

    @FindBy(how = How.XPATH, using = "//*[@id='content']/div/a/i")
    WebElement logoutBtn;

    public void successMsg(){
        if (loginSuccessMsg.isDisplayed()){
            System.out.println("Success login message is present " + loginSuccessMsg.getText());
        }else {
            System.out.println("Success login message is not present " + loginSuccessMsg.getText());
        }

    }

    public void isTitlePageAvailable(){
        String expectedTitle = "Secure Area";
        String actualTitle = titlePage.getText();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Success - The correct title is displayed on the page ");
        }else {
            System.out.println("Failed - An incorrect title is displayed on the page");
        }
    }

    public void clickLogoutBtn(){
        if (logoutBtn.isDisplayed()){
            System.out.println("Logout button is present in the page" + logoutBtn.getText());
        }else {
            System.out.println("Logout button is not present in the page" + logoutBtn.getText());
        }
        logoutBtn.click();
    }
}
