package com.herokuapp.tests;

import com.herokuapp.Base;
import com.herokuapp.webpages.A_B_TestingPage;
import com.herokuapp.webpages.Add_Remove;
import com.herokuapp.webpages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Add_Remove_Test extends Base {

    @Test
    public void valid_add_page(){
        MainPage mainPage = new MainPage(driver);
        mainPage.click_on_add_remove();

        Add_Remove add_remove = new Add_Remove(driver);
        Assert.assertEquals(add_remove.getTitlePageText(),"Add/Remove Elements");

        add_remove.click_add_btn();
        Assert.assertFalse(add_remove.isDeleteBtnDisplayed());

        add_remove.click_detele_btn();
        Assert.assertFalse(add_remove.deleteBtnNotDisplayed());

    }
}
