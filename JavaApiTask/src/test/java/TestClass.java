import Data.LoginRequestClass;
import Data.LoginResponseClass;
import Data.MerchantInfoResponseClass;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestClass {

    //test cases:
    //1. check status code when logging in with valid credentials
    //2. check status code when trying to login with invalid credentials
    //3. check status code of calling GetMerchantAPI with valid token
    //4. check status code of calling GetMerchantAPI without token

    private static RequestSpecification requestSpec;
    private static LoginRequestClass loginRequest;
    private static LoginResponseClass loginResponse;
    private static String token;

    @BeforeAll
    public static void createRequestSpecification() {
        requestSpec = new RequestSpecBuilder().setBaseUri("https://pay.foodics.dev/public-api/v1/App").build()
                .contentType(ContentType.JSON).log().all();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

    }

    @Order(1)
    @Test
    @DisplayName("Check status code returned when trying to login with invalid credentials")
    public void checkResponseCodeReturnedIfLoginFunctionWithInValidCredentials() {
        //1. validate that status code is = 401 when password is invalid
        //2. check error message in the response body
        //3. check status code in the response body
        loginRequest = new LoginRequestClass();
        loginRequest.setPassword("InvalidPassword");
        loginResponse= given(requestSpec).contentType(ContentType.JSON).body(loginRequest).log().all().when().
                post("Login").as(LoginResponseClass.class);
        Assertions.assertEquals(401,loginResponse.getStatusCode());
        Assertions.assertEquals("[Your username and/or password are invalid]", Arrays.toString(loginResponse.getErrors()));
    }

    @Order(2)
    @Test
    @DisplayName("Check status code returned when logging in with valid credentials")
    public void checkResponseCodeReturnedFromLoginFunctionWithValidCredentials() {
        //1. validate that status code = 200 when credentials are valid
        loginRequest = new LoginRequestClass();
        token = given(requestSpec).contentType(ContentType.JSON).body(loginRequest).log().all().when().
                post("Login").then().assertThat()
                .statusCode(200).extract().path("token");
        //System.out.println(token);
    }

    @Order(3)
    @Test
    @DisplayName("check status code when calling GetMerchantAPI with valid token")
    public void checkStatusCodeWhenTokenIsValid() {
        //1. validate that status code is 200, when token is valid
        given(requestSpec).header("User-Agent","PostmanRuntime/7.29.2").header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive").header("Authorization","ApiKey "+token).
                when().get("GetMerchantInfo").then().assertThat().statusCode(200);
    }

    @Order(4)
    @Test
    @DisplayName("check status code when calling GetMerchantAPI without token")
    public void checkStatusCodeWhenNoTokenUsed() {
        //1. validate that status code is 401, when token is not sent
        MerchantInfoResponseClass merchantInfoResponse=given(requestSpec).header("User-Agent","PostmanRuntime/7.29.2").header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive").when().get("GetMerchantInfo").as(MerchantInfoResponseClass.class);

        Assertions.assertEquals(401,merchantInfoResponse.getStatusCode());
        Assertions.assertEquals("[Missing token]",Arrays.toString(merchantInfoResponse.getErrors()));

    }


}
