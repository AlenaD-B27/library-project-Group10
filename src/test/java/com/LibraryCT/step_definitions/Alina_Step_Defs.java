package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.*;
import com.LibraryCT.utilities.BrowserUtil;
import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alina_Step_Defs {
    LoginPage loginPage = new LoginPage();


    DashBoardPage dashBoardPage = new DashBoardPage();
    BookPage bookPage = new BookPage();
    String bookName;
    BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();
    UserPage userPage = new UserPage();

    @Given("I login as a {string} by Alina")
    public void i_login_as_a_by_alina(String user) {
        loginPage.login(user);
        BrowserUtil.waitFor(3);
    }

    @Given("I navigate to {string} page by Alina")
    public void i_navigate_to_page_by_alina(String module) {

        bookPage.navigateModule(module);
        BrowserUtil.waitFor(3);
    }

    @Given("I search book name called {string} by Alina")
    public void i_search_book_name_called_by_alina(String name) {
        bookName = name;
        bookPage.search.sendKeys(bookName);
        BrowserUtil.waitFor(3);
    }

    @When("I click Borrow Book by Alina")
    public void i_click_borrow_book_by_alina() {

        BrowserUtil.selectByVisibleText(userPage.numberOfUsersDropdown, "500");
        BrowserUtil.waitFor(3);
        bookPage.borrowBook.click();

    }

    @Then("verify that book is shown in {string} page by Alina")
    public void verify_that_book_is_shown_in_page_by_alina(String module) {
        dashBoardPage.navigateModule(module);
        BrowserUtil.waitFor(3);

        Assert.assertTrue(BrowserUtil.getElementsText(borrowedBooksPage.allBorrowedBooksName).contains(bookName));
    }

    @Then("verify logged student has same book in database by Alina")
    public void verify_logged_student_has_same_book_in_database_by_alina() {
        List<String> allActualInfo = new ArrayList<>();
        for(int i = 0; i < bookPage.allCells.size(); i++){
            String info = bookPage.allCells.get(i).getText();
            allActualInfo.add(info.toLowerCase());
        }
        String query = "select full_name,b.name,bb.borrowed_date from users u\n" +
                "inner join book_borrow bb on u.id = bb.user_id\n" +
                "inner join books b on bb.book_id = b.id\n" +
                "where full_name='Test Student 35'\n" +
                "order by 3 desc";
        DB_Util.runQuery(query);
        List <String> expectedInfoBook = DB_Util.getRowDataAsList(1);
        for(int i = 0; i < expectedInfoBook.size(); i++){
            if(allActualInfo.get(i).contains(bookName)){
                Assert.assertEquals(expectedInfoBook.get(i), allActualInfo.get(i));
            }
        }
    }
}

