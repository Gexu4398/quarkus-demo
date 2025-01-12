package com.gexu.quarkusdemo.bizservice.models.util;

import io.quarkus.panache.common.Sort;
import io.quarkus.panache.common.Sort.Direction;
import jakarta.annotation.Nonnull;

public class SortUtl {

  public static Sort validateSortField(@Nonnull String sortField, @Nonnull String sortOrder) {

    return sortOrder.equals("asc") ? Sort.by(sortField).direction(Direction.Ascending) :
        Sort.by(sortField).direction(Direction.Descending);
  }
}
