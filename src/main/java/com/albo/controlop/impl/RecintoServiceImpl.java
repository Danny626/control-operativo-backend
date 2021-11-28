package com.albo.controlop.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.controlop.model.Recinto;
import com.albo.controlop.repository.IRecintoRepository;
import com.albo.controlop.service.IRecintoService;

@Service
public class RecintoServiceImpl implements IRecintoService {

	@Autowired
	private IRecintoRepository recintoDao;
	
	@Override
	public List<Recinto> findAll() {
		return recintoDao.findAll();
	}

	@Override
	public Optional<Recinto> findById(String id) {
		return recintoDao.findById(id);
	}

	@Override
	public Recinto saveOrUpdate(Recinto t) {
		return recintoDao.save(t);
	}

	@Override
	public Boolean deleteById(String id) {
		if (!recintoDao.existsById(id)) {
			return false;
		}
		
		recintoDao.deleteById(id);
		return true;
	}

}
