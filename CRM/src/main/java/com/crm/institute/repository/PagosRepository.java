package com.crm.institute.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crm.institute.enttity.Pagos;
import com.crm.institute.enttity.ColegiaturasView;

@Repository
public interface PagosRepository extends CrudRepository<Pagos, Long> {

	@Query(value = "select * from listadoColegiaturas", nativeQuery = true)
	public ArrayList<ColegiaturasView> findPendientePago();
}
