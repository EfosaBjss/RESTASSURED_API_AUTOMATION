package JsonServerTests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class testPATCH {

    @Test
    public void test_Patch() {
        JSONObject request = new JSONObject();
        request.put("firstName", "Tom");
        request.put("lastName", "NewCooper");
        request.put("subjectId", 1);

        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "Application/json").
                body(request.toJSONString()).
        when().
                patch("/users/4").
        then().statusCode(200).
                log().all();
    }
}
