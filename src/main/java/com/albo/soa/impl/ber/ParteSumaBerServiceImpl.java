package com.albo.soa.impl.ber;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.ParteSuma;
import com.albo.soa.repository.ber.IParteSumaBerRepository;
import com.albo.soa.service.ber.IParteSumaBerService;

@Service
public class ParteSumaBerServiceImpl implements IParteSumaBerService {

	@Autowired
	private IParteSumaBerRepository parteSumaBerRepo;

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
		return parteSumaBerRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParteSuma buscarPorIdSuma(String idSuma) {
		return parteSumaBerRepo.buscarPorIdSuma(idSuma);
	}

	@Override
	public List<ParteSuma> buscarPorSync(boolean sync) {
		return parteSumaBerRepo.buscarPorSync(sync);
	}

	@Override
	public ParteSuma buscarPorPrmSuma(String prmSuma) {
		return parteSumaBerRepo.buscarPorPrmSuma(prmSuma);
	}

}
