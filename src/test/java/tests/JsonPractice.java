package tests;

import io.restassured.path.json.JsonPath;

public class JsonPractice {
    public static void main(String[] args) {
        String json = "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "\n" +
                "}";
        JsonPath js = new JsonPath(json);
        System.out.println(js.getDouble("location.lat"));
        System.out.println(js.getString("types[1]"));



    }
}
