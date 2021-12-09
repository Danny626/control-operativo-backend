package com.albo.controlop.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.controlop.model.EstadoParte;
import com.albo.controlop.model.ParteSuma;
import com.albo.controlop.repository.IParteSumaRepository;
import com.albo.controlop.service.IParteSumaService;

@Service
public class ParteSumaServiceImpl implements IParteSumaService {

	@Autowired
	private IParteSumaRepository parteSumaRepo;

	@Override
	public List<ParteSuma> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ParteSuma> findById(Integer id) {
		return parteSumaRepo.findById(id);
	}

	@Override
	public ParteSuma saveOrUpdate(ParteSuma t) {
		return parteSumaRepo.save(t);
	}

	@Override
	public Boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParteSuma buscarPorParteRecepcion(String parteRecepcion) {
		return parteSumaRepo.buscarPorParteRecepcion(parteRecepcion);
	}

	@Override
	public ParteSuma buscarPorRegistroRepetido(String parteRecepcion, EstadoParte estadoParte,
			LocalDateTime fechaRecepcion, String nroManifiesto, String registroManifiesto, String documentoEmbarque,
			String documentoRelacionado, String placaPatente) {
		return parteSumaRepo.buscarPorRegistroRepetido(parteRecepcion, estadoParte, fechaRecepcion, 
				nroManifiesto, registroManifiesto, documentoEmbarque, documentoRelacionado, placaPatente);
	}

	@Override
	public List<ParteSuma> buscarPorFechaRecepcion(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		return parteSumaRepo.buscarPorFechaRecepcion(fechaInicial, fechaFinal);
	}

}
