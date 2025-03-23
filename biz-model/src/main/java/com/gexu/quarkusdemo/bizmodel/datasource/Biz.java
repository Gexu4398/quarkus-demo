package com.gexu.quarkusdemo.bizmodel.datasource;

import io.agroal.api.AgroalDataSource;
import jakarta.inject.Inject;

public class Biz {

  @Inject
  AgroalDataSource defaultDataSource;
}
