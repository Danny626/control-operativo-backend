package com.albo.soa.impl.psg;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.AccessTokenSuma;
import com.albo.soa.repository.psg.IAccessTokenSumaPsgRepository;
import com.albo.soa.service.psg.IAccessTokenSumaPsgService;

@Service
public class AccessTokenSumaPsgServiceImpl implements IAccessTokenSumaPsgService {

	@Autowired
	private IAccessTokenSumaPsgRepository accessTokenSumaPsgRepo;

	@Override
	public List<AccessTokenSuma> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AccessTokenSuma> findById(Long id) {
		return accessTokenSumaPsgRepo.findById(id);
	}

	@Override
	public AccessTokenSuma saveOrUpdate(AccessTokenSuma t) {
		return accessTokenSumaPsgRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		if (!accessTokenSumaPsgRepo.existsById(id)) {
			return false;
		}

		accessTokenSumaPsgRepo.deleteById(id);
		return true;
	}

	@Override
	public AccessTokenSuma buscarPorUsuario(String usuario) {
		return accessTokenSumaPsgRepo.buscarPorUsuario(usuario);
	}

}
