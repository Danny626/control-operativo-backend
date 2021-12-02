package com.albo.controlop.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.controlop.model.UsuarioParte;
import com.albo.controlop.repository.IUsuarioParteRepository;
import com.albo.controlop.service.IUsuarioParteService;

@Service
public class UsuarioParteServiceImpl implements IUsuarioParteService {

	@Autowired
	private IUsuarioParteRepository usuarioParteRepo;

	@Override
	public List<UsuarioParte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UsuarioParte> findById(String id) {
		return usuarioParteRepo.findById(id);
	}

	@Override
	public UsuarioParte saveOrUpdate(UsuarioParte t) {
		return usuarioParteRepo.save(t);
	}

	@Override
	public Boolean deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
