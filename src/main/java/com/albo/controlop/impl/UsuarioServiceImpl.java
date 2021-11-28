package com.albo.controlop.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.albo.controlop.model.Usuario;
import com.albo.controlop.repository.IUsuarioRepository;
import com.albo.controlop.service.IUsuarioService;
import com.albo.exception.ModelAlreadyExistsException;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepository dao;
	
	@Override
	public List<Usuario> findAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Usuario> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Usuario saveOrUpdate(Usuario t) {
		if ( dao.findById(t.getUsername()).isPresent() ) {
			throw new ModelAlreadyExistsException("El usuario ya existe");
		}
		return dao.save(t);
	}

	@Override
	public Boolean deleteById(String id) {
		if (!dao.existsById(id)) {
			return false;
		}
		dao.deleteById(id);
		return true;
	}

	@Override
	public Page<Usuario> listarPageable(Pageable pageable) {
		return dao.findAll(
				PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("username").ascending()));
	}

	@Override
	public Usuario listarPorUsername(String username) {
		return dao.listarPorUsername(username);
	}

	@Override
	public Page<Usuario> buscarXUsername(Pageable pageable, String username) {
		return dao.buscarXNombre(
				PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("username").ascending()),
				username);
	}

	@Override
	public byte[] leerArchivo(String pathFoto) {
		Path path = Paths.get(pathFoto);
		byte[] bArray = null;

		try {
			bArray = Files.readAllBytes(path);
		} catch (IOException e) {
			throw new RuntimeException("Error. El archivo no puede ser abierto porq no existe");
		}
		return bArray;
	}

}
