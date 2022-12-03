package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.BookPage;
import com.LibraryCT.pages.DashBoardPage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.BrowserUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Maria_Step_Defs {
    DashBoardPage dashBoardPage = new DashBoardPage();
    BookPage bookPage = new BookPage();
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
    public void i_search_book_name_called_by_maria(String bookName) {
        bookPage.search.sendKeys(bookName);
    }
    @When("I click Borrow Book by Maria")
    public void i_click_borrow_book_by_maria() {

    }
    @Then("verify that book is shown in {string} page by Maria")
    public void verify_that_book_is_shown_in_page_by_maria(String string) {


    }
    @Then("verify logged student has same book in database by Maria")
    public void verify_logged_student_has_same_book_in_database_by_maria() {

    }
}
