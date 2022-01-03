package com.albo.soa.impl.psg;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.albo.soa.model.VInventarioEgr;
import com.albo.soa.repository.psg.IVInventarioEgrPsgRepository;
import com.albo.soa.service.psg.IVInventarioEgrPsgService;

@Service
public class VInventarioEgrPsgServiceImpl implements IVInventarioEgrPsgService {

	@Autowired
	private IVInventarioEgrPsgRepository vInventarioEgrPsgRepo;

	@Override
	public List<VInventarioEgr> listarVInventarioEgr(String fechaSalida, String recinto, String estado,
			String fechaInicial, String fechaFinal) {
		return vInventarioEgrPsgRepo.listarVInventarioEgr(fechaSalida, recinto, estado, fechaInicial, fechaFinal);
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
