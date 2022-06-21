package firstAPITest;

import io.restassured.http.ContentType;
import netscape.javascript.JSObject;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class Tests_POST {

    @Test
    public void test_1_post (){
     /*   Map<String, Object> map = new HashMap<String, Object>();
        map.put("name" , "RagHav");
        map.put("job", "Teacher");

        System.out.println(map);

        //convert map into json object
        JSONObject request = new JSONObject(map);
        System.out.println(request);  */

        // To run the request directly without converting to map
        JSONObject request = new JSONObject();
        request.put("name" , "RagHav");
        request.put("job", "Teacher");
        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("https://reqres.in/api/users").
        then().
                statusCode(201);
    }
}
