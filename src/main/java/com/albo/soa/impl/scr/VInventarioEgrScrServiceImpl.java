package com.albo.soa.impl.scr;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.albo.soa.model.VInventarioEgr;
import com.albo.soa.repository.scr.IVInventarioEgrScrRepository;
import com.albo.soa.service.scr.IVInventarioEgrScrService;

@Service
public class VInventarioEgrScrServiceImpl implements IVInventarioEgrScrService {

	@Autowired
	private IVInventarioEgrScrRepository vInventarioEgrScrRepo;

	@Override
	public List<VInventarioEgr> listarVInventarioEgr(String fechaSalida, String recinto, String estado,
			String fechaInicial, String fechaFinal) {
		return vInventarioEgrScrRepo.listarVInventarioEgr(fechaSalida, recinto, estado, fechaInicial, fechaFinal);
	}

	@Override
	public List<VInventarioEgr> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VInventarioEgr> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<VInventarioEgr> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<VInventarioEgr> findById(BigInteger id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
