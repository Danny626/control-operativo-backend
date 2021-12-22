package com.albo.soa.impl.alt;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.ParteSuma;
import com.albo.soa.repository.alt.IParteSumaAltRepository;
import com.albo.soa.service.alt.IParteSumaAltService;

@Service
public class ParteSumaAltServiceImpl implements IParteSumaAltService {

	@Autowired
	private IParteSumaAltRepository parteSumaAltRepo;

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
		return parteSumaAltRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParteSuma buscarPorIdSuma(String idSuma) {
		return parteSumaAltRepo.buscarPorIdSuma(idSuma);
	}

	@Override
	public List<ParteSuma> buscarPorSync(boolean sync) {
		return parteSumaAltRepo.buscarPorSync(sync);
	}

}
