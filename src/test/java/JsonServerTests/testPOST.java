package JsonServerTests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class testPOST {

    @Test
    public void test_Post() {
        JSONObject request = new JSONObject();
        request.put("firstName", "Tom");
        request.put("lastName", "Cooper");
        request.put("subjectId", 1);

        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "Application/json").
                body(request.toJSONString()).
        when().
                post("/users").
        then().statusCode(201).
                log().all();
    }
}