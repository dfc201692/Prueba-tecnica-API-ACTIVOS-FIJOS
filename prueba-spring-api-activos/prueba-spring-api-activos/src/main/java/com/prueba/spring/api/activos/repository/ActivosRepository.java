package com.prueba.spring.api.activos.repository;

import org.springframework.stereotype.Repository;
import com.prueba.spring.api.activos.model.Activos;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ActivosRepository extends CrudRepository<Activos,Long> {

}
