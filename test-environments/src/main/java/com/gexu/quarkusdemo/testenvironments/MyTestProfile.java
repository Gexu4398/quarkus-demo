package com.gexu.quarkusdemo.testenvironments;

import io.quarkus.test.junit.QuarkusTestProfile;
import java.util.Map;

public class MyTestProfile implements QuarkusTestProfile {
  @Override
  public String getConfigProfile() {
    return "test";
  }

  @Override
  public Map<String, String> getConfigOverrides() {
    return Map.of(
        "quarkus.hibernate-orm.log.sql", "true",
        "quarkus.hibernate-orm.log.format-sql", "true",
        "quarkus.log.category.liquibase.level", "DEBUG"
    );
  }
}
