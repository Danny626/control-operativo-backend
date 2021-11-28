package com.albo.controlop.service;

import com.albo.controlop.model.Usuario;

public interface ILoginService {

	Usuario verificarNombreUsuario(String usuario, String estado);

	int cambiarClave(String clave, String nombre) throws Exception;

}
