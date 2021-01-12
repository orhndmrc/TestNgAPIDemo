package resources;

import pojo.AddUser;

public class TestPayloadBuild {
    public AddUser createUser(){
        AddUser user = new AddUser();
        user.setId(3456);
        user.setName("Burhan");
        user.setEmail("huuj@gmail.com");
        user.setGender("Male");
        user.setStatus("Active");
        return user;
    }
}
