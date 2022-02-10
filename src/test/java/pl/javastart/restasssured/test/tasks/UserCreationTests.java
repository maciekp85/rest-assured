package pl.javastart.restasssured.test.tasks;

import org.testng.annotations.Test;
import pl.javastart.main.pojo.User;

import static io.restassured.RestAssured.given;

public class UserCreationTests extends TestBase {

    @Test
    public void givenCorrectUserDataWhenCreateUserThenUserIsCreatedTest() {
        User user = new User();
        user.setId(445);
        user.setUsername("firstuser");
        user.setFirstName("Krzysztof");
        user.setLastName("Kowalski");
        user.setEmail("krzysztof@test.com");
        user.setPassword("password");
        user.setPhone("+123456789");
        user.setUserStatus(1);

        given().contentType("application/json")
                .body(user)
                .when().post("user")
                .then().statusCode(200);

        given().contentType("application/json")
                .pathParam("username", user.getUsername())
                .when().get("user/{username}")
                .then().statusCode(200);
    }
}
