package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.*;
import com.LibraryCT.utilities.BrowserUtil;
import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maria_Step_Defs {
    DashBoardPage dashBoardPage = new DashBoardPage();
    BookPage bookPage = new BookPage();
    UserPage userPage = new UserPage();
    BorrowedBookPage borrowedBookPage = new BorrowedBookPage();
    String bookName;
    @Given("I login as a {string} by Maria")
    public void i_login_as_a_by_maria(String student) {
        new LoginPage().login(student);
        BrowserUtil.waitFor(3);

    }
    @Given("I navigate to {string} page by Maria")
    public void i_navigate_to_page_by_maria(String navigateToBook) {
        dashBoardPage.navigateModule(navigateToBook);
        BrowserUtil.waitFor(3);
    }
    @Given("I search book name called {string} by Maria")
    public void i_search_book_name_called_by_maria(String name) {
        bookName=name;
        bookPage.search.sendKeys(bookName);
    }
    @When("I click Borrow Book by Maria")
    public void i_click_borrow_book_by_maria() {
        BrowserUtil.selectByVisibleText(userPage.numberOfUsersDropdown,"500");
        BrowserUtil.waitFor(3);
        bookPage.borrowBook.click();
    }
    @Then("verify that book is shown in {string} page by Maria")
    public void verify_that_book_is_shown_in_page_by_maria(String borrowingBookModule) {
        dashBoardPage.navigateModule(borrowingBookModule);
        BrowserUtil.waitFor(3);
        Assert.assertTrue(BrowserUtil.getElementsText(borrowedBookPage.allBorrowedBooksName).contains(bookName));

    }
    @Then("verify logged student has same book in database by Maria")
    public void verify_logged_student_has_same_book_in_database_by_maria() {

        String query = "select full_name,b.name,bb.borrowed_date from users u\n" +
                "inner join book_borrow bb on u.id = bb.user_id\n" +
                "inner join books b on bb.book_id = b.id\n" +
                "where full_name='Test Student 35'\n" +
                "order by 3 desc";
        DB_Util.runQuery(query);
        List<String> allActualInfo = new ArrayList<>();
        for(int i = 0; i < bookPage.allCell.size(); i++){
        String info = bookPage.allCell.get(i).getText();
        allActualInfo.add(info.toLowerCase());
        List <String> expectedInfoBook = DB_Util.getRowDataAsList(1);

        for(int j = 0; j < expectedInfoBook.size(); j++){
            if(allActualInfo.get(i).contains(bookName)){
                Assert.assertEquals(expectedInfoBook.get(j), allActualInfo.get(i));
            }
        }

    }
}
}

