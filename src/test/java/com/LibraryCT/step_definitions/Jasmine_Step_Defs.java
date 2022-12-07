package com.LibraryCT.step_definitions;


import com.LibraryCT.pages.BookPage;
import com.LibraryCT.pages.DashBoardPage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.BrowserUtil;
import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

import java.util.List;

public class Jasmine_Step_Defs extends LoginPage {

LoginPage loginPage = new LoginPage();


    BookPage bookPage=new BookPage();
    List<String> actualCategoryList;



    @Given("I login as a {string} by Jasmine")
    public void i_login_as_a_by_jasmine(String userType) {
        loginPage.login(userType);
        BrowserUtil.waitFor(3);
    }


    @When("I navigate to {string} page by Jasmine")
    public void i_navigate_to_page_by_jasmine(String string) {
        new DashBoardPage().navigateModule(string);
        BrowserUtil.waitFor(3);
    }


    @When("I take all book categories in UI by Jasmine")
    public void i_take_all_book_categories_in_ui_by_jasmine() {
        bookPage.mainCategoryElement.click();
        actualCategoryList=BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        actualCategoryList.remove(0);
        System.out.println("actualCategoryList = " + actualCategoryList);
        BrowserUtil.waitFor(3);
    }


    @When("I execute query to get book categories by Jasmine")
    public void i_execute_query_to_get_book_categories_by_jasmine() {
        //String query="select name from book_categories";
        DB_Util.runQuery( "select name from book_categories");
        //System.out.println("hi = "+DB_Util.getRowCount());

    }


    @Then("verify book categories must match book_categories table from db by Jasmine")
    public void verify_book_categories_must_match_book_categories_table_from_db_by_jasmine(List<String>expectedCategoryList) {
       //List<String>expectedCategoryList=DB_Util.getColumnDataAsList(1);
        Assert.assertEquals(expectedCategoryList, actualCategoryList);




    }
}
