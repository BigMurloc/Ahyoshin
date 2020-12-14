package pl.ahyoshin.demo;

import io.restassured.http.ContentType;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import pl.ahyoshin.demo.requests.RegisterRequest;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@IntegrationTest
public class RegisterIT {

    @AfterClass
    public static void afterClass(){
        //todo: deleteUser
    }

    @Test
    public void whenCorrectRequestBodyShouldRegisterUserOK200(){
        given()
                .body(new RegisterRequest("user", "password"))
                .contentType(ContentType.JSON)
                .post("/api/register")
        .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void whenIncorrectRequestBodyShouldBadRequest400(){
        given()
                .contentType(ContentType.JSON)
                .post("/api/register")
        .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

}
