package resources;

public enum ResourcePaths {
    getUsers("/public-api/users"),
    addUser("/public-api/users"),
    getSingleUser("/public-api/users/123"),
    deleteUser("/public-api/users/123");

    private String resource;
    ResourcePaths(String resource){
        this.resource=resource;
    }

    public String getResource(){
        return resource;
    }
}
