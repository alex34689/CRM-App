package com.crm.institute.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crm.institute.enttity.Pagos;

@Repository
public interface PagosRepository extends CrudRepository<Pagos, Long> {

}
