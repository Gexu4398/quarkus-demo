package com.gexu.quarkusdemo.bizkeycloakmodel.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Role {

  private String id;

  private String name;

  private Set<String> scopes;
}
