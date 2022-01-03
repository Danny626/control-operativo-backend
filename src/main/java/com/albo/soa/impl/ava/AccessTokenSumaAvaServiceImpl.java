package com.albo.soa.impl.ava;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.AccessTokenSuma;
import com.albo.soa.repository.ava.IAccessTokenSumaAvaRepository;
import com.albo.soa.service.ava.IAccessTokenSumaAvaService;

@Service
public class AccessTokenSumaAvaServiceImpl implements IAccessTokenSumaAvaService {

	@Autowired
	private IAccessTokenSumaAvaRepository accessTokenSumaAvaRepo;

	@Override
	public List<AccessTokenSuma> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AccessTokenSuma> findById(Long id) {
		return accessTokenSumaAvaRepo.findById(id);
	}

	@Override
	public AccessTokenSuma saveOrUpdate(AccessTokenSuma t) {
		return accessTokenSumaAvaRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		if (!accessTokenSumaAvaRepo.existsById(id)) {
			return false;
		}

		accessTokenSumaAvaRepo.deleteById(id);
		return true;
	}

	@Override
	public AccessTokenSuma buscarPorUsuario(String usuario) {
		return accessTokenSumaAvaRepo.buscarPorUsuario(usuario);
	}

}
