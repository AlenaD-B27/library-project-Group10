package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.BookPage;
import com.LibraryCT.pages.BorrowedBooksPage;
import com.LibraryCT.pages.DashBoardPage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.BrowserUtil;
import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Zorig_Step_Defs {
    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();
    BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    String actualNumber;

    @Given("user login as a {string} by Zorig")
    public void user_login_as_a_by_zorig(String user) {
        loginPage.login(user);
        BrowserUtil.waitFor(3);

    }
    @When("user take borrowed books number by Zorig")
    public void user_take_borrowed_books_number_by_zorig() {
        dashBoardPage=new DashBoardPage();
        actualNumber = dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualNumber = " + actualNumber);

    }
    @Then("borrowed books number information must match with DB by Zorig")
    public void borrowed_books_number_information_must_match_with_db_by_zorig() {
        String query="select count(*) from book_borrow\n" +
                "where is_returned=0";
        DB_Util.runQuery(query);

        String expectedNumber = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedNumber,actualNumber);

    }
    @Given("I login as a {string} by Zorig")
    public void i_login_as_a_by_zorig(String userType) {
        loginPage.login(userType);
        BrowserUtil.waitFor(3);

    }
    @Given("I navigate to {string} page by Zorig")
    public void i_navigate_to_page_by_zorig(String string) {

    }
    @When("the librarian click to add book by Zorig")
    public void the_librarian_click_to_add_book_by_zorig() {

    }
    @When("the librarian enter book name {string} by Zorig")
    public void the_librarian_enter_book_name_by_zorig(String string) {

    }
    @When("the librarian enter ISBN {string} by Zorig")
    public void the_librarian_enter_isbn_by_zorig(String string) {

    }
    @When("the librarian enter year {string} by Zorig")
    public void the_librarian_enter_year_by_zorig(String string) {

    }
    @When("the librarian enter author {string} by Zorig")
    public void the_librarian_enter_author_by_zorig(String string) {

    }
    @When("the librarian choose the book category {string} by Zorig")
    public void the_librarian_choose_the_book_category_by_zorig(String string) {

    }
    @When("the librarian click to save changes by Zorig")
    public void the_librarian_click_to_save_changes_by_zorig() {

    }
    @Then("the librarian verify new book by {string} by Zorig")
    public void the_librarian_verify_new_book_by_by_zorig(String string) {

    }
    @Then("the librarian verify new book from database by {string} by Zorig")
    public void the_librarian_verify_new_book_from_database_by_by_zorig(String string) {

    }
}
