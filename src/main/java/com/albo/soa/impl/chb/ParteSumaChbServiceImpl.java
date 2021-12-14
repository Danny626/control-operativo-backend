package com.albo.soa.impl.chb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.ParteSuma;
import com.albo.soa.repository.chb.IParteSumaChbRepository;
import com.albo.soa.service.chb.IParteSumaChbService;

@Service
public class ParteSumaChbServiceImpl implements IParteSumaChbService {

	@Autowired
	private IParteSumaChbRepository parteSumaChbRepo;

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
		return parteSumaChbRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParteSuma buscarPorIdSuma(String idSuma) {
		return parteSumaChbRepo.buscarPorIdSuma(idSuma);
	}

}
