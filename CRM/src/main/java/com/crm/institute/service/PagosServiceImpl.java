package com.crm.institute.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.institute.Exception.CustomeFieldValidationException;
import com.crm.institute.enttity.Pagos;
import com.crm.institute.repository.PagosRepository;

@Service
public class PagosServiceImpl implements PagosService {

	@Autowired
	PagosRepository pagosRepository;

	@Override
	public Iterable<Pagos> getAllPagos() {
		return pagosRepository.findAll();
	}

	private boolean checkImporteAvailable(Pagos pagos) throws Exception {
		if (pagos.getImporte() <= 0) {
			throw new CustomeFieldValidationException("Importe incorrecto", "importe");
		}
		return true;
	}

	@Override
	public Pagos createPago(Pagos pago) throws Exception {
		if (checkImporteAvailable(pago)) {
			Date date = new Date();
			pago.setFecha(date);
			pago = pagosRepository.save(pago);
		}
		return pago;
	}

	@Override
	public Pagos getPagosByIdPago(Long idAlumno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
