package com.albo.soa.impl.alt;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.AccessTokenSuma;
import com.albo.soa.repository.alt.IAccessTokenSumaAltRepository;
import com.albo.soa.service.alt.IAccessTokenSumaAltService;

@Service
public class AccessTokenSumaAltServiceImpl implements IAccessTokenSumaAltService {

	@Autowired
	private IAccessTokenSumaAltRepository accessTokenSumaAltRepo;

	@Override
	public List<AccessTokenSuma> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AccessTokenSuma> findById(Long id) {
		return accessTokenSumaAltRepo.findById(id);
	}

	@Override
	public AccessTokenSuma saveOrUpdate(AccessTokenSuma t) {
		return accessTokenSumaAltRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		if (!accessTokenSumaAltRepo.existsById(id)) {
			return false;
		}

		accessTokenSumaAltRepo.deleteById(id);
		return true;
	}

	@Override
	public AccessTokenSuma buscarPorUsuario(String usuario) {
		return accessTokenSumaAltRepo.buscarPorUsuario(usuario);
	}

}
