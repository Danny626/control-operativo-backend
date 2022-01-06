package com.albo.controlop.service;

import com.albo.controlop.model.Tarea;

public interface ITareaService extends IService<Tarea, Long> {

	Tarea buscarPorNombre(String codRecinto, String tipo);
}
