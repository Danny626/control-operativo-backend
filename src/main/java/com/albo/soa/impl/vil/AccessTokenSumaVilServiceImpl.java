package com.albo.soa.impl.vil;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.AccessTokenSuma;
import com.albo.soa.repository.vil.IAccessTokenSumaVilRepository;
import com.albo.soa.service.vil.IAccessTokenSumaVilService;

@Service
public class AccessTokenSumaVilServiceImpl implements IAccessTokenSumaVilService {

	@Autowired
	private IAccessTokenSumaVilRepository accessTokenSumaVilRepo;

	@Override
	public List<AccessTokenSuma> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AccessTokenSuma> findById(Long id) {
		return accessTokenSumaVilRepo.findById(id);
	}

	@Override
	public AccessTokenSuma saveOrUpdate(AccessTokenSuma t) {
		return accessTokenSumaVilRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		if (!accessTokenSumaVilRepo.existsById(id)) {
			return false;
		}

		accessTokenSumaVilRepo.deleteById(id);
		return true;
	}

	@Override
	public AccessTokenSuma buscarPorUsuario(String usuario) {
		return accessTokenSumaVilRepo.buscarPorUsuario(usuario);
	}

}
