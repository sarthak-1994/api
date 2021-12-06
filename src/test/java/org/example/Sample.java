package org.example;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Sample {

    private static Response resp;
    @BeforeTest
    public  void setup()
    {
         resp =  given().baseUri("http://fakeapi.jsonparseronline.com/")
                .when().get("/users/1");
    }


    @Test
    public void verifyStatusCode()
    {
        resp.then().assertThat().statusCode(200);
    }

    @Test
    public void verifyResponseBody()
    {
       JsonPath jp = new JsonPath(resp.getBody().asString());
        Assert.assertEquals(jp.get("maritalStatus"),"Single");
    }

}
