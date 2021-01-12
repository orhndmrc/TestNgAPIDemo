package util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ResourcePaths;

import java.util.List;

import static io.restassured.RestAssured.given;

public class TestUtil {
    RequestSpecification request;
    Response response;
    ResponseSpecification resspec;
    Response res;
    public RequestSpecification requestSpecification(){
       request = given().log().all().spec(new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("baseURI")).
           addHeader("Authorization",ConfigReader.getProperty("token")).setContentType(ContentType.JSON).build());
       return request;
    }
    public void responseSpecification(int statusCose){
         resspec = new ResponseSpecBuilder().expectStatusCode(statusCose).expectContentType(ContentType.JSON).build();

    }
    public void executeAPI(String httpMethod, String basePath){

        switch (httpMethod) {
            case "GET":
                response = request.when().get(basePath);
                break;
            case "POST":
                response = request.when().post(basePath);
                break;
            case "PUT":
                response = request.when().put(basePath);
                break;
            case "DELETE":
                response =request.when().delete(basePath);
                break;
            default:
                System.out.println("Please pass the correct http method");
                break;
        }


    }
    public Response getResponse(){
         return response.then().log().all().spec(resspec).extract().response();

    }
    // generic methods for response:
    public  JsonPath getJsonPath(Response response) {
        return new JsonPath(response.asString());
    }

    public  int getStatucCode(Response response) {
        return response.getStatusCode();
    }

    public  String getHeaderValue(Response response, String headerName) {
        return response.getHeader(headerName);
    }

    public int getResponseHeaderCount(Response response) {
        Headers headers = response.getHeaders();
        return headers.size();
    }

    public static List<Header> getResponseHeaders(Response response) {
        Headers headers = response.getHeaders();
        List<Header> headerList = headers.asList();
        return headerList;
    }
    public String getBasePath(String resource){
        ResourcePaths rsc =ResourcePaths.valueOf(resource);
        return rsc.getResource();
    }

}
