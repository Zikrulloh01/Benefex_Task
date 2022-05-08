package com.api_tests.step_definitions;

import com.api_tests.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.*;

public class count_posts_steps {

    Response response;
    List<Integer> list;
    List<Integer> countedList = new ArrayList<>();


    @Given("User goes to the end url")
    public void user_goes_to_the_end_url() {
        // sending get request to endpoint
        response = given().accept(ContentType.JSON)
                .when().get(ConfigurationReader.get("url"));
    }

    @When("User enters user {string}")
    public void user_enters_user(String id) {
        //I am using jsonPath to get json response into list
        JsonPath jsonPath = response.jsonPath();
        // store all user ids into a list
        list =  jsonPath.get("userId");
        for (Integer integer : list) {
            if (integer.equals(Integer.parseInt(id))){
                // I am checking if response has given id add that into counted list
                countedList.add(integer);
            }
        }
    }

    @Then("User verifies number of posts")
    public void user_verifies_number_of_posts() {
        //verify expected and actual numbers match
        Assert.assertEquals(10, countedList.size());
        System.out.println("Number of posts for this user: " + countedList.size());
    }

    @Then("Verify each post has unique id")
    public void verifyEachPostHasUniqueId() {
        //storing all post ids in to a list
        ArrayList<String> idList = response.jsonPath().get("id");
        System.out.println(idList);
    }
}
