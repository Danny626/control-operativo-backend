package com.albo.soa.service;

import com.albo.controlop.service.IService;
import com.albo.soa.model.ParteSuma;

public interface IParteSumaService extends IService<ParteSuma, Long> {

	ParteSuma buscarPorIdSuma(String idSuma);

}
