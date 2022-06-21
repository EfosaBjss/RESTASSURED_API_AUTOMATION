package DataDrivenTest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class DD_Test_Post extends DataForTests{

  /*  @DataProvider(name = "DataForPost")
    public Object [] [] dataForPost() {

      /*  Object [][] data= new Object[2][3];

        data [0][0] = "Albert";
        data [0][1] = "Einsten";
        data [0][2] = 2;

        data [1][0] = "Thomas";
        data [1][1] = "Edison";
        data [1][2] = 1;
        return  data;

        return new Object[][]{
                {"Graham", "Bell1", 1},
                {"Henry", "Ford1", 1},

        };


    } */

    // Inheriting data from the superclass DataForTest with the extends keyword

    @Test(dataProvider = "DataForPost")
    public void test_Post(String firstName, String lastName, int subjectId) {
        JSONObject request = new JSONObject();

        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subjectId", subjectId);

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
