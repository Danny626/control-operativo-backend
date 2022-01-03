package com.albo.soa.impl.tam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.AccessTokenSuma;
import com.albo.soa.repository.tam.IAccessTokenSumaTamRepository;
import com.albo.soa.service.tam.IAccessTokenSumaTamService;

@Service
public class AccessTokenSumaTamServiceImpl implements IAccessTokenSumaTamService {

	@Autowired
	private IAccessTokenSumaTamRepository accessTokenSumaTamRepo;

	@Override
	public List<AccessTokenSuma> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AccessTokenSuma> findById(Long id) {
		return accessTokenSumaTamRepo.findById(id);
	}

	@Override
	public AccessTokenSuma saveOrUpdate(AccessTokenSuma t) {
		return accessTokenSumaTamRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		if (!accessTokenSumaTamRepo.existsById(id)) {
			return false;
		}

		accessTokenSumaTamRepo.deleteById(id);
		return true;
	}

	@Override
	public AccessTokenSuma buscarPorUsuario(String usuario) {
		return accessTokenSumaTamRepo.buscarPorUsuario(usuario);
	}

}
