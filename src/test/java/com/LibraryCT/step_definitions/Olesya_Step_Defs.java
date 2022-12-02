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
import org.junit.Assert;

import java.util.List;
import java.util.Map;


public class Olesya_Step_Defs {


    String module;
    LoginPage loginPage = new LoginPage();

    DashBoardPage dashBoardPage = new DashBoardPage();

    BookPage bookPage = new BookPage();


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

    @When("the librarian enter book name {string} by Olesya")
    public void the_librarian_enter_book_name_by_olesya(String string) {
        BrowserUtil.waitFor(2);

        String query = "select name from book_category_id";

        //run query to get all categories from Database
        DB_Util.runQuery(query);

        //store data
        List<String> expectedBookCategoryId = DB_Util.getColumnDataAsList(1);

        //Assertion
        Assert.assertEquals(expectedBookCategoryId, actualCategoryList);


        BrowserUtil.waitFor(4);
        System.out.println("-----Assertion step-----");
        System.out.println(bookPage.bookName.getText());
        System.out.println("getAttribute(value)--> " + bookPage.bookName.getAttribute("value"));
        System.out.println("bookPage.bookName.getAttribute(\"innerHTMl\") = " + bookPage.bookName.getAttribute("outerHTML"));


        // get data from UI
        String actualBookName = bookPage.bookName.getAttribute("value");
//        String actualISBN = bookPage.isbn.getAttribute("value");
//        String actualYear = bookPage.year.getAttribute("value");
//        String actualAuthorName = bookPage.author.getAttribute("value");
//        String actualCategoryList = bookPage.author.getAttribute("value");

        // get data from Database
//        String query = "select name from isbn,year,author,category from books\n" +
//                "where name='" + bookName + "'";

        DB_Util.runQuery(query);
        //store information
        Map<String, String> bookInfo = DB_Util.getRowMap(1);
        System.out.println("---- DATA FROM DATABASE ---- ");
        String expectedBookName = bookInfo.get("name");
        System.out.println(expectedBookName);
//        String expectedISBN = bookInfo.get("isbn");
//        String expectedYear = bookInfo.get("year");
//        String expectedAuthorName = bookInfo.get("author");
        //String expectedBookCategoryId = bookInfo.get("mainCategoryElement");


        // compare
        Assert.assertEquals(expectedBookName, actualBookName);
//        Assert.assertEquals(expectedISBN, actualISBN);
//        Assert.assertEquals(expectedYear, actualYear);
//        Assert.assertEquals(expectedAuthorName, actualAuthorName);
       Assert.assertEquals(expectedBookCategoryId, actualCategoryList);

        BrowserUtil.waitFor(2);


    }

//   userPage.bookName.sendKeys();




    @When("the librarian enter ISBN {string} by Olesya")
    public void the_librarian_enter_isbn_by_olesya(String string) {

    }
    @When("the librarian enter year {string} by Olesya")
    public void the_librarian_enter_year_by_olesya(String string) {

    }
    @When("the librarian enter author {string} by Olesya")
    public void the_librarian_enter_author_by_olesya(String string) {

    }
    @When("the librarian choose the book category {string} by Olesya")
    public void the_librarian_choose_the_book_category_by_olesya(String string) {

    }
    @When("the librarian click to save changes by Olesya")
    public void the_librarian_click_to_save_changes_by_olesya() {

    }
    @Then("the librarian verify new book by {string} by Olesya")
    public void the_librarian_verify_new_book_by_by_olesya(String string) {

    }
    @Then("the librarian verify new book from database by {string} by Olesya")
    public void the_librarian_verify_new_book_from_database_by_by_olesya(String string) {

    }
}
