package resources;

import pojo.AddUser;

public class TestPayloadBuild {
    public AddUser createUser(){
        AddUser user = new AddUser();
        user.setId(10946);
        user.setName("Mustafa");
        user.setEmail("msthh@gmail.com");
        user.setGender("Male");
        user.setStatus("Active");
        return user;
    }
}
