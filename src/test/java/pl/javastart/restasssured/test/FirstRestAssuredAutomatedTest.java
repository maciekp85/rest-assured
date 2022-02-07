package pl.javastart.restasssured.test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FirstRestAssuredAutomatedTest {

    @Test
    public void givenNonExistingPetIdWhenGetPenThenPetNotFoundTest() {
        given().when().get("https://swaggerpetstore.przyklady.javastart.pl/v2/pet/0").then().statusCode(404);
    }

    @Test
    public void moreDescribingGivenNonExistingPetIdWhenGetPenThenPetNotFoundTest() {
        // given() method creates request specification
        RequestSpecification given = given();

        // when() method returns itself, meaning actual request specification, acts as a binder, given section with then
        RequestSpecification when = given.when();

        // get() method executes http request using http get method
        Response response = when.get("https://swaggerpetstore.przyklady.javastart.pl/v2/pet/0");

        // then() method takes a response and change it into ValidatableResponse object, it can execute assertion on it
        // built in RestAssured framework
        ValidatableResponse then = response.then();

        // Execute assertion with statusCode() method, checking if status code equals 404
        then.statusCode(404);
    }
}
