package com.albo.controlop.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Optional<ParteSuma> findById(Long id) {
		return parteSumaRepo.findById(id);
	}

	@Override
	public ParteSuma saveOrUpdate(ParteSuma t) {
		return parteSumaRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParteSuma buscarPorPrmSuma(String prmSuma) {
		return parteSumaRepo.buscarPorPrmSuma(prmSuma);
	}

}
