package com.albo.soa.impl.vir;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.AccessTokenSuma;
import com.albo.soa.repository.vir.IAccessTokenSumaVirRepository;
import com.albo.soa.service.vir.IAccessTokenSumaVirService;

@Service
public class AccessTokenSumaVirServiceImpl implements IAccessTokenSumaVirService {

	@Autowired
	private IAccessTokenSumaVirRepository accessTokenSumaVirRepo;

	@Override
	public AccessTokenSuma buscarPorUsuario(String usuario) {
		return accessTokenSumaVirRepo.buscarPorUsuario(usuario);
	}

	@Override
	public List<AccessTokenSuma> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AccessTokenSuma> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccessTokenSuma saveOrUpdate(AccessTokenSuma t) {
		return accessTokenSumaVirRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		if (!accessTokenSumaVirRepo.existsById(id)) {
			return false;
		}

		accessTokenSumaVirRepo.deleteById(id);
		return true;
	}

}
