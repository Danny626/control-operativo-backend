package com.albo.soa.service;

import java.util.List;

import com.albo.controlop.service.IService;
import com.albo.soa.model.ParteSuma;

public interface IParteSumaService extends IService<ParteSuma, Long> {

	ParteSuma buscarPorIdSuma(String idSuma);
	
	ParteSuma buscarPorPrmSuma(String prmSuma);
	
	List<ParteSuma> buscarPorSync(boolean sync);

}
