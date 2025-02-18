package com.gexu.quarkusdemo.testenvironments;

import com.github.javafaker.Faker;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.Locale;
import javax.sql.DataSource;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * API 测试基类。
 */
@QuarkusTest
@TestProfile(MyTestProfile.class)
@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
public abstract class TestEnvironment {

  protected Faker faker = new Faker(Locale.ENGLISH);

  @Inject
  protected EntityManager entityManager;

  @Inject
  DataSource dataSource;

  @AfterEach
  @SneakyThrows
  public void cleanup() {

    entityManager.clear();

    // 获取数据库连接
    @Cleanup final var conn = dataSource.getConnection();

    // 禁用约束
    conn.createStatement().execute("SET REFERENTIAL_INTEGRITY = FALSE");

    // 罗列表对象
    final var tables = conn.createStatement().executeQuery("show tables");

    // 删除表数据
    while (tables.next()) {
      final var tableName = String.format("%s.%s", tables.getString(2), tables.getString(1));
      conn.createStatement().execute("delete from " + tableName);
    }

    // 启用约束
    conn.createStatement().execute("SET REFERENTIAL_INTEGRITY = TRUE");
  }
}