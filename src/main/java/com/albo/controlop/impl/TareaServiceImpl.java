package com.albo.controlop.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.controlop.model.Tarea;
import com.albo.controlop.repository.ITareaRepository;
import com.albo.controlop.service.ITareaService;

@Service
public class TareaServiceImpl implements ITareaService {

	@Autowired
	private ITareaRepository tareaRepository;

	@Override
	public List<Tarea> findAll() {
		return tareaRepository.findAll();
	}

	@Override
	public Optional<Tarea> findById(Long id) {
		return tareaRepository.findById(id);
	}

	@Override
	public Tarea saveOrUpdate(Tarea t) {
		return tareaRepository.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		if (!tareaRepository.existsById(id)) {
			return false;
		}
		
		tareaRepository.deleteById(id);
		return true;
	}

	@Override
	public Tarea buscarPorNombre(String codRecinto, String tipo) {
		return tareaRepository.buscarPorNombre(codRecinto, tipo);
	}

}
