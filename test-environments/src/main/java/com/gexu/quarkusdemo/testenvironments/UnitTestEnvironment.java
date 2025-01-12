package com.gexu.quarkusdemo.testenvironments;

import io.quarkus.runtime.configuration.ConfigUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;

@Slf4j
public class UnitTestEnvironment extends TestEnvironment {

  @BeforeAll
  void beforeAll() {
    log.info("Active profile: {}", ConfigUtils.getProfiles());
  }
}
