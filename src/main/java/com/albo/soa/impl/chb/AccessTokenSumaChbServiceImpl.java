package com.albo.soa.impl.chb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.AccessTokenSuma;
import com.albo.soa.repository.chb.IAccessTokenSumaChbRepository;
import com.albo.soa.service.chb.IAccessTokenSumaChbService;

@Service
public class AccessTokenSumaChbServiceImpl implements IAccessTokenSumaChbService {

	@Autowired
	private IAccessTokenSumaChbRepository accessTokenSumaChbRepo;

	@Override
	public AccessTokenSuma buscarPorUsuario(String usuario) {
		return accessTokenSumaChbRepo.buscarPorUsuario(usuario);
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
		return accessTokenSumaChbRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		if (!accessTokenSumaChbRepo.existsById(id)) {
			return false;
		}

		accessTokenSumaChbRepo.deleteById(id);
		return true;
	}

}
