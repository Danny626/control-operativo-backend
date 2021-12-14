package com.albo.soa.impl.scz;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.AccessTokenSuma;
import com.albo.soa.repository.scz.IAccessTokenSumaSczRepository;
import com.albo.soa.service.scz.IAccessTokenSumaSczService;

@Service
public class AccessTokenSumaSczServiceImpl implements IAccessTokenSumaSczService {

	@Autowired
	private IAccessTokenSumaSczRepository accessTokenSumaSczRepo;

	@Override
	public AccessTokenSuma buscarPorUsuario(String usuario) {
		return accessTokenSumaSczRepo.buscarPorUsuario(usuario);
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
		return accessTokenSumaSczRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		if (!accessTokenSumaSczRepo.existsById(id)) {
			return false;
		}

		accessTokenSumaSczRepo.deleteById(id);
		return true;
	}

}
