package com.albo.controlop.service;

import com.albo.controlop.model.DestinatarioParte;

public interface IDestinatarioParteService extends IService<DestinatarioParte, Integer> {

	DestinatarioParte buscarPorNombre(String destinatario);

}
