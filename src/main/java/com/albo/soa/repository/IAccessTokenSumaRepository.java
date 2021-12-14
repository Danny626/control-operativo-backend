package com.albo.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.albo.soa.model.AccessTokenSuma;

public interface IAccessTokenSumaRepository extends JpaRepository<AccessTokenSuma, Long> {

	@Query("FROM com.albo.soa.model.AccessTokenSuma at WHERE at.usuario = :usuario")
	AccessTokenSuma buscarPorUsuario(@Param("usuario") String usuario);
}
