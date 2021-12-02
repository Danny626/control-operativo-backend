package com.albo.controlop.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.controlop.model.TipoCargaParte;
import com.albo.controlop.repository.ITipoCargaParteRepository;
import com.albo.controlop.service.ITipoCargaParteService;

@Service
public class TipoCargaParteServiceImpl implements ITipoCargaParteService {

	@Autowired
	private ITipoCargaParteRepository tipoCargaParteRepo;

	@Override
	public List<TipoCargaParte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<TipoCargaParte> findById(String id) {
		return tipoCargaParteRepo.findById(id);
	}

	@Override
	public TipoCargaParte saveOrUpdate(TipoCargaParte t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
