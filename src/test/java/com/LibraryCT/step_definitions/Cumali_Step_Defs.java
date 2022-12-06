package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.BookPage;
import com.LibraryCT.pages.DashBoardPage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.DB_Util;
import com.mysql.cj.log.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class Cumali_Step_Defs {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();
    DashBoardPage dashBoardPage = new DashBoardPage();


    @Given("I login as a {string} by Cumali")
    public void i_login_as_a_by_cumali(String userType) {
        loginPage.login(userType);

    }

    @Given("I navigate to {string} page by Cumali")
    public void i_navigate_to_page_by_cumali(String moduleName) {
        dashBoardPage.navigateModule(moduleName);

    }

    @When("I open book {string} by Cumali")
    public void i_open_book_by_cumali(String bookName) {
        bookPage.search.sendKeys(bookName);

    }

    @Then("book information must match the Database by Cumali")
    public void book_information_must_match_the_database_by_cumali() {
        Map<String, String> actualInfo = new HashMap<>();

        for (int i = 0; i < bookPage.tableHeaderCells.size(); i++) {
            String key = bookPage.tableHeaderCells.get(i).getText();
            String value = bookPage.allCells.get(i).getText();
            actualInfo.put(key.toLowerCase(), value);
        }

        DB_Util.runQuery("select name, author,year from books where name='Chordeiles minor'");
        Map<String, String> expectedInfo = DB_Util.getRowMap(1);
        for (String eachKey : expectedInfo.keySet()) {
            if (actualInfo.containsKey(eachKey)) {
                Assert.assertEquals(expectedInfo.get(eachKey), actualInfo.get(eachKey));
            }

        }
    }}
