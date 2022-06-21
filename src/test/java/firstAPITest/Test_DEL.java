package firstAPITest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Test_DEL {

    @Test
    public void test_1_delete (){

//do not need body for a delete request
       /* JSONObject request = new JSONObject();
        request.put("name" , "RagHav");
        request.put("job", "Teacher");
        System.out.println(request);
        System.out.println(request.toJSONString()); */

      /*  given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).  */
        when().
                delete("https://reqres.in/api/users/2").
        then().
                statusCode(204).
                log().all();

    }
}
