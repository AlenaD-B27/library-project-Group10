package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.BookPage;
import com.LibraryCT.pages.DashBoardPage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.BrowserUtil;
import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Olga_Step_Defs {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();

    List<String> actualAllCategories;


    @Given("I login as a {string} by Olga")
    public void i_login_as_a_by_olga(String user) {
        loginPage.login(user);
        BrowserUtil.waitFor(2);


    }
    @When("I navigate to {string} page by Olga")
    public void i_navigate_to_page_by_olga(String moduleName) {
        new DashBoardPage().navigateModule(moduleName);

    }
    @When("I take all book categories in UI by Olga")
    public void i_take_all_book_categories_in_ui_by_olga() {
        actualAllCategories = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        //actualAllCategories.remove(0);
        //System.out.println("actualAllCategories = " + actualAllCategories);

    }
    @When("I execute query to get book categories by Olga")
    public void i_execute_query_to_get_book_categories_by_olga() {
        actualAllCategories.remove(0);
        System.out.println("actualAllCategories = " + actualAllCategories);


    }
    @Then("verify book categories must match book_categories table from db by Olga")
    public void verify_book_categories_must_match_book_categories_table_from_db_by_olga(List<String> expectedAllCategories) {
        Assert.assertEquals(expectedAllCategories,actualAllCategories);

    }
}
