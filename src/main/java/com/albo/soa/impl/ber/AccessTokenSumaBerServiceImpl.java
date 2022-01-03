package com.albo.soa.impl.ber;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.AccessTokenSuma;
import com.albo.soa.repository.ber.IAccessTokenSumaBerRepository;
import com.albo.soa.service.ber.IAccessTokenSumaBerService;

@Service
public class AccessTokenSumaBerServiceImpl implements IAccessTokenSumaBerService {

	@Autowired
	private IAccessTokenSumaBerRepository accessTokenSumaBerRepo;

	@Override
	public List<AccessTokenSuma> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AccessTokenSuma> findById(Long id) {
		return accessTokenSumaBerRepo.findById(id);
	}

	@Override
	public AccessTokenSuma saveOrUpdate(AccessTokenSuma t) {
		return accessTokenSumaBerRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		if (!accessTokenSumaBerRepo.existsById(id)) {
			return false;
		}

		accessTokenSumaBerRepo.deleteById(id);
		return true;
	}

	@Override
	public AccessTokenSuma buscarPorUsuario(String usuario) {
		return accessTokenSumaBerRepo.buscarPorUsuario(usuario);
	}

}
