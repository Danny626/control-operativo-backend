package com.albo.soa.service;

import java.math.BigInteger;
import java.util.List;

import com.albo.soa.model.VInventarioEgr;

public interface IVInventarioEgrService extends ReadOnlyService<VInventarioEgr, BigInteger> {
	
	List<VInventarioEgr> listarVInventarioEgr(
			String fechaSalida, String recinto, String estado, String fechaInicial, String fechaFinal);

}
