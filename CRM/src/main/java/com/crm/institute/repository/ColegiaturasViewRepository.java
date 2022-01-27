package com.crm.institute.repository;

import java.util.List;

import com.crm.institute.enttity.ColegiaturasView;
import com.crm.institute.service.ReadOnlyService;

public interface ColegiaturasViewRepository extends ReadOnlyService<ColegiaturasView, Long> {
	
	List<ColegiaturasView> findByCiclo(String ciclo);

}
