package com.albo.controlop.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.albo.controlop.model.Rol;
import com.albo.controlop.repository.IRolRepository;
import com.albo.controlop.service.IRolService;


@Service
public class RolServiceImpl implements IRolService {

	@Autowired
	private IRolRepository dao;

	@Override
	public List<Rol> findAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Rol> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Rol saveOrUpdate(Rol t) {
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
	public Page<Rol> listarPageable(Pageable pageable) {
		return dao.findAll(pageable);
	}

	
}
