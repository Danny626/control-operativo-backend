package com.albo.controlop.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.controlop.model.EstadoParte;
import com.albo.controlop.repository.IEstadoParteRepository;
import com.albo.controlop.service.IEstadoParteService;

@Service
public class EstadoParteServiceImpl implements IEstadoParteService {

	@Autowired
	private IEstadoParteRepository estadoParteRepo;

	@Override
	public List<EstadoParte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<EstadoParte> findById(String id) {
		return estadoParteRepo.findById(id);
	}

	@Override
	public EstadoParte saveOrUpdate(EstadoParte t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
