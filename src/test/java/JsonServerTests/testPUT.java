package JsonServerTests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class testPUT {

    @Test
    public void test_PUT() {
        JSONObject request = new JSONObject();
        request.put("firstName", "Mary");
        request.put("lastName", "Jane");
        request.put("subjectId", 1);

        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "Application/json").
                body(request.toJSONString()).
        when().
                put("/users/4").
        then().statusCode(200).
                log().all();
    }

}
