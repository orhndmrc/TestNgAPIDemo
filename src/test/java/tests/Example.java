package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Example {
    @Test
    public void users(){
        RestAssured.baseURI="https://gorest.co.in";
        String response =given().log().all().header("Authorization","Bearer 44e66e9fb7f714874b09ed79987210545326360d759e67d85b97d56782b8f244")
                .header("Accept","application/json").header("Content-Type","application/json")
                .when().get("/public-api/users").then().log().all().statusCode(200).extract().asString();

        validatingKeysInListofJsonObjects(response,"data");

        /*JsonPath js = new JsonPath(response);

        List<Map<String, String>> outputjson = js.getList("data");
        //System.out.println(outputjson);

        ArrayList<String> s =new ArrayList<>();//Arrays.asList("id","name","email","gender","status","created_at","updated_at")
        for (String keys : outputjson.get(0).keySet())
        {
            s.add(keys);
        }
        for (int i = 0; i <outputjson.size() ; i++) {
            for (int j = 0; j <s.size() ; j++) {
                Assert.assertTrue(outputjson.get(i).containsKey(s.get(j)));
            }

        }
        //System.out.println(outputjson.get(0).keySet());
        //x = outputjson.get(0).keySet();


        //Assert.assertTrue(outputjson.get(0).containsKey("id"));*/



            
        }
        public void validatingKeysInListofJsonObjects(String response,String listOfObjects){
            JsonPath js = new JsonPath(response);

            List<Map<String, String>> outputjson = js.getList(listOfObjects);
            //System.out.println(outputjson);

            ArrayList<String> s =new ArrayList<>();//Arrays.asList("id","name","email","gender","status","created_at","updated_at")
            for (String keys : outputjson.get(0).keySet())
            {
                s.add(keys);
            }
            for (int i = 0; i <outputjson.size() ; i++) {
                for (int j = 0; j <s.size() ; j++) {
                    Assert.assertTrue(outputjson.get(i).containsKey(s.get(j)));
                }

            }
        }
    }





