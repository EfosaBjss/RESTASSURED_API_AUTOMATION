package JsonServerTests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class testDELETE {

    @Test
    public void test_delete() {

        baseURI = "http://localhost:3000/";
        when().
                delete("/users/4").
        then().
                statusCode(200);

    }
}
