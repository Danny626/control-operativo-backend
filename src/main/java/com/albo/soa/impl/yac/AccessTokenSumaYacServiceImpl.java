package com.albo.soa.impl.yac;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.AccessTokenSuma;
import com.albo.soa.repository.yac.IAccessTokenSumaYacRepository;
import com.albo.soa.service.yac.IAccessTokenSumaYacService;

@Service
public class AccessTokenSumaYacServiceImpl implements IAccessTokenSumaYacService {

	@Autowired
	private IAccessTokenSumaYacRepository accessTokenSumaYacRepo;

	@Override
	public List<AccessTokenSuma> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AccessTokenSuma> findById(Long id) {
		return accessTokenSumaYacRepo.findById(id);
	}

	@Override
	public AccessTokenSuma saveOrUpdate(AccessTokenSuma t) {
		return accessTokenSumaYacRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		if (!accessTokenSumaYacRepo.existsById(id)) {
			return false;
		}

		accessTokenSumaYacRepo.deleteById(id);
		return true;
	}

	@Override
	public AccessTokenSuma buscarPorUsuario(String usuario) {
		return accessTokenSumaYacRepo.buscarPorUsuario(usuario);
	}

}
