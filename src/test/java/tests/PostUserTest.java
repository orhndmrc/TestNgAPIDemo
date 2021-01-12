package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.TestPayloadBuild;
import util.TestUtil;

public class PostUserTest extends TestUtil {
    String basePath;
    TestPayloadBuild data;
    @BeforeTest
    public void setUp(){
        basePath = getBasePath("addUser");
        data= new TestPayloadBuild();

    }
    @Test(description = "Creating a new user")
    public void addSingleUser(){
        requestSpecification().body(data.createUser());
        executeAPI("POST",basePath);
        responseSpecification(201);
        getResponse();

    }

}
