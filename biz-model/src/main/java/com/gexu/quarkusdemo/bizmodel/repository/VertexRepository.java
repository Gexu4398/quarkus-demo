package com.gexu.quarkusdemo.bizmodel.repository;

import com.gexu.quarkusdemo.bizmodel.models.Vertex;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VertexRepository implements PanacheRepository<Vertex> {

}
