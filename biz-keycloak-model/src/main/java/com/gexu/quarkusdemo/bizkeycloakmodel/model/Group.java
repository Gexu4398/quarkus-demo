package com.gexu.quarkusdemo.bizkeycloakmodel.model;

import io.quarkus.hibernate.orm.PersistenceUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PersistenceUnit("keycloak")
public class Group {

  private String id;

  private String name;

  private String parentId;
}
