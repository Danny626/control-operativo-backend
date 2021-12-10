package com.albo.controlop.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.controlop.model.EstadoParte;
import com.albo.controlop.model.ParteSumaExcel;
import com.albo.controlop.repository.IParteSumaExcelRepository;
import com.albo.controlop.service.IParteSumaExcelService;

@Service
public class ParteSumaExcelServiceImpl implements IParteSumaExcelService {

	@Autowired
	private IParteSumaExcelRepository parteSumaRepo;

	@Override
	public List<ParteSumaExcel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ParteSumaExcel> findById(Integer id) {
		return parteSumaRepo.findById(id);
	}

	@Override
	public ParteSumaExcel saveOrUpdate(ParteSumaExcel t) {
		return parteSumaRepo.save(t);
	}

	@Override
	public Boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParteSumaExcel buscarPorParteRecepcion(String parteRecepcion) {
		return parteSumaRepo.buscarPorParteRecepcion(parteRecepcion);
	}

	@Override
	public ParteSumaExcel buscarPorRegistroRepetido(String parteRecepcion, EstadoParte estadoParte,
			LocalDateTime fechaRecepcion, String nroManifiesto, String registroManifiesto, String documentoEmbarque,
			String documentoRelacionado, String placaPatente) {
		return parteSumaRepo.buscarPorRegistroRepetido(parteRecepcion, estadoParte, fechaRecepcion, 
				nroManifiesto, registroManifiesto, documentoEmbarque, documentoRelacionado, placaPatente);
	}

	@Override
	public List<ParteSumaExcel> buscarPorFechaRecepcion(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		return parteSumaRepo.buscarPorFechaRecepcion(fechaInicial, fechaFinal);
	}

}
