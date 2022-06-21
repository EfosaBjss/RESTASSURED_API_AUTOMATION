package DataDrivenTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

public class DD_Test_Delete extends DataForTests{

   /* @DataProvider(name = "DeleteData")
    public Object[] dataForDelete(){
        return new Object[]{
                5,6
        };

    }  */

  //  Inheriting data from the superclass DataForTests

  //  @Test(dataProvider = "DeleteData")
    public void test_delete( int userId) {

        baseURI = "http://localhost:3000/";
        when().
                delete("/users/"+userId).
                then().
                statusCode(200);

    }


    @Parameters({"userId"})
    @Test
    public void test_delete2( int userId) {
        System.out.println("value of userId is:" + userId);

        baseURI = "http://localhost:3000/";
        when().
                delete("/users/"+userId).
                then().
                statusCode(200);

    }
}
