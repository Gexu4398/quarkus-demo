package com.gexu.quarkusdemo.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.gexu.quarkusdemo.testenvironments.UnitTestEnvironment;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class StudentResourceTest extends UnitTestEnvironment {

  @Test
  public void testGetStudents() {

    given()
        .queryParam("page", 0)
        .queryParam("size", 10)
        .queryParam("sort", "createdAt")
        .queryParam("order", "desc")
        .when()
        .get("/student")
        .then()
        .statusCode(200)
        .body("content.size()", equalTo(0));
  }

  @Test
  public void testAddStudent() {

    final var name = faker.name().fullName();

    given()
        .contentType(ContentType.JSON)
        .body(name)
        .when()
        .post("/student")
        .then()
        .statusCode(200)
        .body("name", equalTo(name));
  }
}
