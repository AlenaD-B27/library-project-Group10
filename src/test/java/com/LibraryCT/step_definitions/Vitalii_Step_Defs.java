package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.DashBoardPage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Vitalii_Step_Defs {

    String actualResult;
    List<String> actualList;
    String actualGenreDB;

    @Given("Establish the database connection by Vitalii")
    public void establish_the_database_connection_by_vitalii() {


    }
    @When("Execute query to get all IDs from users by Vitalii")
    public void execute_query_to_get_all_i_ds_from_users_by_vitalii() {
        String query1 = "select count(id) from users";

        DB_Util.runQuery(query1);
        actualResult = DB_Util.getFirstRowFirstColumn();

    }
    @Then("verify all users has unique ID by Vitalii")
    public void verify_all_users_has_unique_id_by_vitalii() {
        String query2 = "select count(distinct id) from users";
        DB_Util.runQuery(query2);
        String expectedResult = DB_Util.getCellValue(1,1);
        System.out.println("expectedResult = " + expectedResult);
        System.out.println("actualResult = " + actualResult);
        Assert.assertEquals(expectedResult,actualResult);


    }

    @When("Execute query to get all columns by Vitalii")
    public void execute_query_to_get_all_columns_by_vitalii() {
        DB_Util.runQuery("select * from users");
        actualList = DB_Util.getAllColumnNamesAsList();

        System.out.println("actualResult = " + actualResult);

    }
    @Then("verify the below columns are listed in result by Vitalii")
    public void verify_the_below_columns_are_listed_in_result_by_vitalii(List<String> expectedResult) {
        System.out.println("expectedResult = " + expectedResult);

        Assert.assertEquals(expectedResult, actualList);

    }
    @When("I execute query to find most popular book genre by Vitalii")
    public void i_execute_query_to_find_most_popular_book_genre_by_vitalii() {
        String query = "select bc.name, count(*) from book_borrow bb inner join books b on bb.book_id = b.id inner join book_categories bc on b.book_category_id = bc.id group by bc.name order by count(*) desc";
        DB_Util.runQuery(query);
        actualGenreDB = DB_Util.getFirstRowFirstColumn();
        DB_Util.getCellValue(1,2);

    }


    @Then("verify {string} is the most popular book genre by Vitalii")
    public void verify_is_the_most_popular_book_genre_by_vitalii(String expectedGenre) {

        Assert.assertEquals(expectedGenre, actualGenreDB);
    }
}
