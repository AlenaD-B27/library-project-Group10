package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.DashBoardPage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.BrowserUtil;
import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Elena_Step_Defs {

    LoginPage LoginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    String actualBorrowedBookNumber;
    @Given("user login as a {string} by Elena")
    public void user_login_as_a_by_elena(String user) {

        LoginPage.login(user);
        BrowserUtil.waitFor(3);
    }
    @When("user take borrowed books number by Elena")
    public void user_take_borrowed_books_number_by_elena() {

        actualBorrowedBookNumber = dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualBorrowedBookNumber = " + actualBorrowedBookNumber);
        BrowserUtil.waitFor(3);
    }
    @Then("borrowed books number information must match with DB by Elena")
    public void borrowed_books_number_information_must_match_with_db_by_elena() {

        DB_Util.runQuery("select count(*) as borrowedBooks from users u\n" +
                "inner join book_borrow b on u.id = b.user_id\n" +
                "where is_returned = 0");
        String expectedBookBorrow =   DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(expectedBookBorrow,actualBorrowedBookNumber);
        BrowserUtil.waitFor(3);
    }
}
