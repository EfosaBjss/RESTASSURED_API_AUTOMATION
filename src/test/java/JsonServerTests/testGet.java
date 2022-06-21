package JsonServerTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class testGet {
    @Test
    public  void Test_getLocal(){
        baseURI = "http://localhost:3000/";
        given().
                param("name", "Automation").
                get("/subjects").
        then().
                statusCode(200).
                log().all();
    }
}
