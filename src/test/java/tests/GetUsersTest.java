package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import listener.ExtentReportListener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.ResourcePaths;
import util.TestUtil;

import static io.restassured.RestAssured.given;
@Epic("Epic - User Details")
@Feature("US-101: define the get user feature...")
@Listeners(ExtentReportListener.class)
public class GetUsersTest extends TestUtil {

    String basePath;
    @BeforeTest
    public void setUp(){
        basePath = getBasePath("getUsers");

    }
    @Test(description = "test case name = get a single user's details")
    @Severity(SeverityLevel.CRITICAL)
    public void getUserDetails(){
        requestSpecification().queryParam("name","Andrea Gracanin");
        executeAPI("GET",basePath);
        responseSpecification(200);
        Response response = getResponse();
        int status = response.getStatusCode();
        Assert.assertEquals(status,200);
        String email = getJsonPath(response).getString("data.status");
        System.out.println(email);

    }

}
