package com.crm.institute.service;

import com.crm.institute.enttity.Pagos;

public interface PagosService {

	public Iterable<Pagos> getAllPagos();

	public Pagos createPago(Pagos pago) throws Exception;

	public Pagos getPagosByIdPago(Long idAlumno) throws Exception;

}
