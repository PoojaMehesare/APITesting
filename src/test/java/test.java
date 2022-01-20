import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class test {
    public static String userID;

    @Test
    public void GetUserProfile() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer BQAqIszyEapWble4uvHLVcfZQsby_Iph4kqVTkop10kpkXWxJqzZ3pT-NtDAOd9_SycANpupY-vrq4Y_USh2uMxfYlt7lacN8J_W2tyHvDYWLeZ6AGn2iuA5F-JRB9Fl9krYKMP-JjQwpxfCjVEkzTnsTN6Wuw3UfwGKcRcUy7cGnYtfh8itkQytTIJZb-EEdLbobSq9HqbaaEJCdorvT4XMFVq4OK8apNXBdWp8pt6DLfMLaK2_kfmop_TvQ3QkzjT1iWFrOVICjFEQ4dMtUI7JN0eyiHObF7DXHq4cKg")
                .get("https://api.spotify.com/v1/me");
        response.prettyPrint();
        Assert.assertEquals(userID, "31weqs6ydeomwmitcoxvkrzh57re");
        int statusCode = response.getStatusCode();
        System.out.println("status code is:" + statusCode);
        Assert.assertEquals(statusCode, 200);

    }
}
