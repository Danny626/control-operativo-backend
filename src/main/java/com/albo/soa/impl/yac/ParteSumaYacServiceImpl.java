package com.albo.soa.impl.yac;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.ParteSuma;
import com.albo.soa.repository.yac.IParteSumaYacRepository;
import com.albo.soa.service.yac.IParteSumaYacService;

@Service
public class ParteSumaYacServiceImpl implements IParteSumaYacService {

	@Autowired
	private IParteSumaYacRepository parteSumaYacRepo;

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
		return parteSumaYacRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParteSuma buscarPorIdSuma(String idSuma) {
		return parteSumaYacRepo.buscarPorIdSuma(idSuma);
	}

	@Override
	public List<ParteSuma> buscarPorSync(boolean sync) {
		return parteSumaYacRepo.buscarPorSync(sync);
	}

	@Override
	public ParteSuma buscarPorPrmSuma(String prmSuma) {
		return parteSumaYacRepo.buscarPorPrmSuma(prmSuma);
	}

}
