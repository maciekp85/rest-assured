package pl.javastart.restasssured.test.tasks;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserCreationTests {

    @Test
    public void givenCorrectUserDataWhenCreateUserThenUserIsCreatedTest() {
        String user = "{\n" +
                "  \"id\": 445,\n" +
                "  \"username\": \"firstuser\",\n" +
                "  \"firstName\": \"Krzysztof\",\n" +
                "  \"lastName\": \"Kowalski\",\n" +
                "  \"email\": \"krzysztof@test.com\",\n" +
                "  \"password\": \"password\",\n" +
                "  \"phone\": \"+123456789\",\n" +
                "  \"userStatus\": 1\n" +
                "}";
        given().log().all()
                .contentType("application/json")
                .body(user)
                .when().post("https://swaggerpetstore.przyklady.javastart.pl/v2/user")
                .then().log().all().statusCode(200);
    }
}
