package com.crm.institute.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crm.institute.enttity.Pagos;
import com.crm.institute.enttity.PendientePago;

@Repository
public interface PagosRepository extends CrudRepository<Pagos, Long> {

//	@Query(value = "", nativeQuery = true)
//	public ArrayList<PendientePago> findPendientePago();
}
