package com.albo.soa.service;

import com.albo.controlop.service.IService;
import com.albo.soa.model.AccessTokenSuma;

public interface IAccessTokenSumaService extends IService<AccessTokenSuma, Long> {

	AccessTokenSuma buscarPorUsuario(String usuario);
}
