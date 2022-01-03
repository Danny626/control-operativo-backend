package com.albo.soa.impl.ava;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.ParteSuma;
import com.albo.soa.repository.ava.IParteSumaAvaRepository;
import com.albo.soa.service.ava.IParteSumaAvaService;

@Service
public class ParteSumaAvaServiceImpl implements IParteSumaAvaService {

	@Autowired
	private IParteSumaAvaRepository parteSumaAvaRepo;

	@Override
	public List<ParteSuma> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ParteSuma> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParteSuma saveOrUpdate(ParteSuma t) {
		return parteSumaAvaRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParteSuma buscarPorIdSuma(String idSuma) {
		return parteSumaAvaRepo.buscarPorIdSuma(idSuma);
	}

	@Override
	public List<ParteSuma> buscarPorSync(boolean sync) {
		return parteSumaAvaRepo.buscarPorSync(sync);
	}

	@Override
	public ParteSuma buscarPorPrmSuma(String prmSuma) {
		return parteSumaAvaRepo.buscarPorPrmSuma(prmSuma);
	}

}
