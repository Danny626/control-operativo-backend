package com.albo.soa.impl.vil;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.ParteSuma;
import com.albo.soa.repository.vil.IParteSumaVilRepository;
import com.albo.soa.service.vil.IParteSumaVilService;

@Service
public class ParteSumaVilServiceImpl implements IParteSumaVilService {

	@Autowired
	private IParteSumaVilRepository parteSumaVilRepo;

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
		return parteSumaVilRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParteSuma buscarPorIdSuma(String idSuma) {
		return parteSumaVilRepo.buscarPorIdSuma(idSuma);
	}

	@Override
	public List<ParteSuma> buscarPorSync(boolean sync) {
		return parteSumaVilRepo.buscarPorSync(sync);
	}

	@Override
	public ParteSuma buscarPorPrmSuma(String prmSuma) {
		return parteSumaVilRepo.buscarPorPrmSuma(prmSuma);
	}

}
