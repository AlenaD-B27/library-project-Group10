package com.LibraryCT.step_definitions;

import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Aysun_Step_Defs {

    // making these 2 to make it global, so I can reach them...
    String actualResult;
    List<String> actualList;
    @Given("Establish the database connection by Aysun")
    public void establish_the_database_connection_by_aysun() {
        DB_Util.createConnection();
    }

    @When("Execute query to get all IDs from users by Aysun")
    public void execute_query_to_get_all_i_ds_from_users_by_aysun() {
        String query1 = "select count(id) from users";
        DB_Util.runQuery(query1);
       actualResult = DB_Util.getFirstRowFirstColumn();

    }
    @Then("verify all users has unique ID by Aysun")
    public void verify_all_users_has_unique_id_by_aysun() {
        String query2 = "select count(distinct id) from users";
        DB_Util.runQuery(query2);
        String expectedResult = DB_Util.getCellValue(1,1);
        Assert.assertEquals(expectedResult,actualResult);
    }

    @When("Execute query to get all columns by Aysun")
    public void execute_query_to_get_all_columns_by_aysun() {
    DB_Util.runQuery("select * from users");
        actualList = DB_Util.getAllColumnNamesAsList();
        System.out.println("actualList = " + actualList);
    }

    @Then("verify the below columns are listed in result by Aysun")
    public void verify_the_below_columns_are_listed_in_result_by_aysun (List<String> expectedList) {
        Assert.assertEquals(expectedList,actualList);
        System.out.println("expectedList = " + expectedList);

    }

}
