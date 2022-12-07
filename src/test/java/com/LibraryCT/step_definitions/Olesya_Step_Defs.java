package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.BookPage;
import com.LibraryCT.pages.DashBoardPage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.pages.UserPage;
import com.LibraryCT.utilities.BrowserUtil;
import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;



public class Olesya_Step_Defs {


    String module;
    LoginPage loginPage = new LoginPage();

    DashBoardPage dashBoardPage = new DashBoardPage();

    BookPage bookPage = new BookPage();

    BookPage bookName = new BookPage();


    UserPage userPage = new UserPage();


    List<String> actualCategoryList;


    @Given("I login as a {string} by Olesya")
    public void i_login_as_a_by_olesya(String username) {
        loginPage.login(username);
        BrowserUtil.waitFor(4);

    }

    @Given("I navigate to {string} page by Olesya")
    public void i_navigate_to_page_by_olesya(String string) {
        new DashBoardPage().getModuleBooks(module);
        BrowserUtil.waitFor(2);

    }

    @Given("I click on the {string} module by Olesya")
    public void i_click_on_the_module_by_olesya(String string) {
        BrowserUtil.waitFor(2);
        userPage.bookButton.click();
        BrowserUtil.waitFor(2);
    }

    @When("the librarian click to add book by Olesya")
    public void the_librarian_click_to_add_book_by_olesya() {
        BrowserUtil.waitFor(2);
        userPage.addBook.click();
        BrowserUtil.waitFor(2);

    }

    String expected = "";
    @When("the librarian enter book name {string} by Olesya")
    public void the_librarian_enter_book_name_by_olesya(String bookName) {
        BrowserUtil.waitFor(2);
        bookPage.bookName.sendKeys(bookName);
        expected += bookName;
    }


    @When("the librarian enter ISBN {string} by Olesya")
    public void the_librarian_enter_isbn_by_olesya(String isbn) {
        bookPage.isbn.sendKeys(isbn);

    }
    @When("the librarian enter year {string} by Olesya")
    public void the_librarian_enter_year_by_olesya(String year) {
        bookPage.year.sendKeys(year);

    }
    @When("the librarian enter author {string} by Olesya")
    public void the_librarian_enter_author_by_olesya(String author) {
        bookPage.author.sendKeys(author);
    }
    @When("the librarian choose the book category {string} by Olesya")
    public void the_librarian_choose_the_book_category_by_olesya(String category) {
        BrowserUtil.selectOptionDropdown(bookPage.categoryDropDown,category);
        BrowserUtil.waitFor(3);

    }
    @When("the librarian click to save changes by Olesya")
    public void the_librarian_click_to_save_changes_by_olesya() {
        bookPage.saveChangesBtn.click();
        BrowserUtil.waitFor(2);
        bookPage.search.sendKeys(expected);
        BrowserUtil.waitFor(2);

    }
    @Then("the librarian verify new book by {string} by Olesya")
    public void the_librarian_verify_new_book_by_by_olesya(String bookName) {

    }
    @Then("the librarian verify new book from database by {string} by Olesya")
    public void the_librarian_verify_new_book_from_database_by_by_olesya(String bookNameFromReq) {
        String actualBookName = bookPage.verifyFileName(bookPage.verifyBookName,bookNameFromReq);
        System.out.println("actualBookName = " + actualBookName);

        //get data from database
        DB_Util.runQuery("select b.name,isbn,author from books b where b.name ='" + bookNameFromReq);
    }
}
