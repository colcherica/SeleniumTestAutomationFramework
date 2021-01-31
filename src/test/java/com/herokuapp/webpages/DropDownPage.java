package com.herokuapp.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.How;

public class DropDownPage {
    WebDriver driver;

    public DropDownPage( WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "div h3")
    WebElement titleHeader;

    @FindBy(how = How.ID, using = "dropdown")
    WebElement dropdown;

    public void clickOnDropDownMenu() throws Exception{
       try {
           dropdown.click();
       } catch (Exception e) {
           //TODO: handle exception
           System.out.println("The element is not present" + e);
       }
    }

}
