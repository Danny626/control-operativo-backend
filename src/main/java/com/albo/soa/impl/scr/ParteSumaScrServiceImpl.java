package com.albo.soa.impl.scr;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.ParteSuma;
import com.albo.soa.repository.scr.IParteSumaScrRepository;
import com.albo.soa.service.scr.IParteSumaScrService;

@Service
public class ParteSumaScrServiceImpl implements IParteSumaScrService {

	@Autowired
	private IParteSumaScrRepository parteSumaScrRepo;

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
		return parteSumaScrRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParteSuma buscarPorIdSuma(String idSuma) {
		return parteSumaScrRepo.buscarPorIdSuma(idSuma);
	}

	@Override
	public List<ParteSuma> buscarPorSync(boolean sync) {
		return parteSumaScrRepo.buscarPorSync(sync);
	}

	@Override
	public ParteSuma buscarPorPrmSuma(String prmSuma) {
		return parteSumaScrRepo.buscarPorPrmSuma(prmSuma);
	}

}
