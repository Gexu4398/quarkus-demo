package com.gexu.quarkusdemo.bizservice.rest;

import com.gexu.quarkusdemo.bizmodel.models.Student;
import com.gexu.quarkusdemo.bizservice.models.result.PageResult;
import com.gexu.quarkusdemo.bizservice.util.SortUtl;
import io.quarkus.panache.common.Page;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/student")
public class StudentResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public PageResult<Student> getStudents(
      @QueryParam("page") @DefaultValue("0") int pageIndex,
      @QueryParam("size") @DefaultValue("10") int pageSize,
      @QueryParam("sort") @DefaultValue("createdAt") String sortField,
      @QueryParam("order") @DefaultValue("asc") String sortOrder) {

    final var page = Page.of(pageIndex, pageSize);
    final var sort = SortUtl.validateSortField(sortField, sortOrder);
    final var query = Student.findAll(sort).page(page);

    return new PageResult<>(query.list(), pageIndex, pageSize, query.pageCount(), query.count(),
        query.hasNextPage(), query.hasPreviousPage());
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Student getStudent(@PathParam("id") String id) {

    Student student = Student.findById(id);
    if (null == student) {
      throw new WebApplicationException(
          Response.status(Response.Status.NOT_FOUND)
              .entity("学生不存在！")
              .build()
      );
    }
    return student;
  }

  @POST
  @Transactional
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Student addStudent(String name) {

    final var student = new Student();
    student.setName(name);
    student.persist();
    return student;
  }
}
