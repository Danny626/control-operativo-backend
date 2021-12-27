package com.albo.controlop.service;

import com.albo.controlop.model.ParteSuma;

public interface IParteSumaService extends IService<ParteSuma, Long> {

	ParteSuma buscarPorPrmSuma(String prmSuma);
	
}
