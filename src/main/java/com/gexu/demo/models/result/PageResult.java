package com.gexu.demo.models.result;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "分页结果")
public class PageResult<T> {

  @Schema(description = "当前页的数据")
  private List<T> content = new ArrayList<>();

  @Schema(description = "当前页码")
  private int pageIndex = 0;

  @Schema(description = "每页大小")
  private int pageSize = 0;

  @Schema(description = "总页数")
  private int totalPages = 0;

  @Schema(description = "总记录数")
  private long totalRecords = 0L;

  @Schema(description = "是否有下一页")
  private boolean hasNext = false;

  @Schema(description = "是否有上一页")
  private boolean hasPrev = false;
}
