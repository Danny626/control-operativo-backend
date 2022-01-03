package com.albo.soa.impl.scr;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.soa.model.AccessTokenSuma;
import com.albo.soa.repository.scr.IAccessTokenSumaScrRepository;
import com.albo.soa.service.scr.IAccessTokenSumaScrService;

@Service
public class AccessTokenSumaScrServiceImpl implements IAccessTokenSumaScrService {

	@Autowired
	private IAccessTokenSumaScrRepository accessTokenSumaScrRepo;

	@Override
	public List<AccessTokenSuma> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AccessTokenSuma> findById(Long id) {
		return accessTokenSumaScrRepo.findById(id);
	}

	@Override
	public AccessTokenSuma saveOrUpdate(AccessTokenSuma t) {
		return accessTokenSumaScrRepo.save(t);
	}

	@Override
	public Boolean deleteById(Long id) {
		if (!accessTokenSumaScrRepo.existsById(id)) {
			return false;
		}

		accessTokenSumaScrRepo.deleteById(id);
		return true;
	}

	@Override
	public AccessTokenSuma buscarPorUsuario(String usuario) {
		return accessTokenSumaScrRepo.buscarPorUsuario(usuario);
	}

}
