package com.albo.controlop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.albo.controlop.model.ParteSuma;

@Repository
public interface IParteSumaRepository extends JpaRepository<ParteSuma, Long> {

	@Query("FROM com.albo.controlop.model.ParteSuma ps WHERE ps.cor = :prmSuma")
	ParteSuma buscarPorPrmSuma(@Param("prmSuma") String prmSuma);
	
}
