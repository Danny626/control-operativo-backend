package com.albo.controlop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.albo.controlop.model.Rol;

public interface IRolService extends IService<Rol, String> {

	Page<Rol> listarPageable(Pageable pageable);
}
