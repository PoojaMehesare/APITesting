import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Apitest {
    public static String userID;
    String token = "";

    @BeforeTest
    public void setup() {
        token = "Bearer BQC5v26q4a8dI5RcbjE7SPVtUppAGXijLNdOxv_Uh51XHjvLeMRuKRsRZx3GM9TRvItrV_8EIV46enoCUH1wfyXEDDWotNDgdMDrglZ1tMXC2PeKP46PI-8uEeoxSE93_4jUvZtt3yLcNf-oNhZ7HSxxJudDfSK7c0TaDYBa0oJGcMWEaHGRu2MsFshyRjUhw-IYPZKe0L7TO1ZVX32VWzn4EKJQKNLIwUlKk3HzbPkxzEN3DFjeKXKkZG8wiJabBcX8O9jd8VkcT_FEMKsoNsjFYkuOM2nPS2trqGHoPA";
    }

    //GET APIs
    @Test
    public void GetUserProfile() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .get("https://api.spotify.com/v1/me");
        response.prettyPrint();
        Assert.assertEquals(userID, "31weqs6ydeomwmitcoxvkrzh57re");
        int statusCode = response.getStatusCode();
        System.out.println("status code is:" + statusCode);
        Assert.assertEquals(statusCode, 200);


    }

    //POST APIs
    @Test
    public void CreatePlaylist() {
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestparam = new JSONObject();
        requestparam.put("name", "New Playlist");
        requestparam.put("description", "New playlist description");
        requestparam.put("public", "false");
        httpRequest.header("Authorization", token);
        httpRequest.body(requestparam.toString());
        Response response = httpRequest.request(Method.POST, "https://api.spotify.com/v1/users/31weqs6ydeomwmitcoxvkrzh57re/playlists");
        String responseBody = response.getBody().asString();
        System.out.println("Response body is:" + responseBody);
        int statusCode = response.getStatusCode();
        System.out.println("status code is:" + statusCode);
        Assert.assertEquals(statusCode, 201);

    }

    //POST APIs
    @Test
    public void CreatePlaylistt() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"name\": \"New Playlist7\",\n" +
                        "  \"description\": \"New playlist description\",\n" +
                        "  \"public\": false\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/31weqs6ydeomwmitcoxvkrzh57re/playlists");
        response.prettyPrint();
        Assert.assertEquals(userID, "31weqs6ydeomwmitcoxvkrzh57re");

    }

    //PUT APIs
    @Test
    public void ChangePlaylistDetails() {
        RequestSpecification httpRequest = given();
        JSONObject requestparam = new JSONObject();
        requestparam.put("name", "pooja");
        requestparam.put("description", "Updated playlist description");
        requestparam.put("public", "false");
        httpRequest.header("Authorization", token);
        httpRequest.body(requestparam.toString());
        Response response = httpRequest.request(Method.PUT, "https://api.spotify.com/v1/playlists/4PEDFs8dI9H2X29lbkV03I");
        String responseBody = response.getBody().asString();
        System.out.println("Response body is:" + responseBody);
    }

    //PUT APIs
    @Test
    public void ChangePlaylistDetail() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"name\": \"pooja\",\n" +
                        "  \"description\": \"New playlist \",\n" +
                        "  \"public\": false\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/0op1NREKEtKgVbTTjrQSSl");
        response.prettyPrint();

    }

    //PUT APIs
    @Test
    public void RemovePlaylistItems() {
        Response response;
        response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        " \"tracks\": [\n" +
                        " {\n" +
                        " \"uri\": \"spotify:track:72zHuDxFQTjbL51qJQSA7j\"\n" +
                        " \n" +
                        " \n" +
                        " \n" +
                        " }\n" +
                        " ]\n" +
                        "}")
                .when()
                .delete("https://api.spotify.com/v1/playlists/0op1NREKEtKgVbTTjrQSSl/tracks");
        response.prettyPrint();
    }
}

