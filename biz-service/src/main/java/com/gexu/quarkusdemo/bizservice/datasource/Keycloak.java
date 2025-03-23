package com.gexu.quarkusdemo.bizservice.datasource;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import jakarta.inject.Inject;

public class Keycloak {

  @Inject
  @DataSource("keycloak")
  AgroalDataSource keycloakDataSource;

}
