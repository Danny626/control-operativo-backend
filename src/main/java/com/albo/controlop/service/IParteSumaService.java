package com.albo.controlop.service;

import java.time.LocalDateTime;

import com.albo.controlop.model.EstadoParte;
import com.albo.controlop.model.ParteSuma;

public interface IParteSumaService extends IService<ParteSuma, Integer> {

	ParteSuma buscarPorParteRecepcion(String parteRecepcion);
	
	ParteSuma buscarPorRegistroRepetido(
			String parteRecepcion, EstadoParte estadoParte,
			LocalDateTime fechaRecepcion, String nroManifiesto,	String registroManifiesto,
			String documentoEmbarque, String documentoRelacionado, String placaPatente);
}
