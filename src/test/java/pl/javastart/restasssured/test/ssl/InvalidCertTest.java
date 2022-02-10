package pl.javastart.restasssured.test.ssl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class InvalidCertTest {

    @Test
    public void untrustedRootTest() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setRelaxedHTTPSValidation();
        RequestSpecification requestSpecification = requestSpecBuilder.build();

        given().spec(requestSpecification).get("https://untrusted-root.badssl.com/").then().statusCode(200);
    }
}
