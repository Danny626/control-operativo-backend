package com.albo.controlop.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.controlop.model.DestinatarioParte;
import com.albo.controlop.repository.IDestinatarioParteRepository;
import com.albo.controlop.service.IDestinatarioParteService;

@Service
public class DestinatarioParteServiceImpl implements IDestinatarioParteService {

	@Autowired
	private IDestinatarioParteRepository destinatarioParteRepo;

	@Override
	public List<DestinatarioParte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<DestinatarioParte> findById(Integer id) {
		return destinatarioParteRepo.findById(id);
	}

	@Override
	public DestinatarioParte saveOrUpdate(DestinatarioParte t) {
		return destinatarioParteRepo.save(t);
	}

	@Override
	public Boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DestinatarioParte buscarPorNombre(String destinatario) {
		return destinatarioParteRepo.buscarPorNombre(destinatario);
	}

}
