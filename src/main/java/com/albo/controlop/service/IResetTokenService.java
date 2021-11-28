package com.albo.controlop.service;

import com.albo.controlop.model.ResetToken;

public interface IResetTokenService {

	ResetToken findByToken(String token);

	void guardar(ResetToken token);

	void eliminar(ResetToken token);

}
