package com.albo.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.albo.soa.model.ParteSuma;

public interface IParteSumaRepository extends JpaRepository<ParteSuma, Long> {
	
	@Query("FROM com.albo.soa.model.ParteSuma ps WHERE ps.idSuma = :idSuma")
	ParteSuma buscarPorIdSuma(@Param("idSuma") String idSuma);
	
	@Query("FROM com.albo.soa.model.ParteSuma ps WHERE ps.cor = :prmSuma")
	ParteSuma buscarPorPrmSuma(@Param("prmSuma") String prmSuma);
	
	@Query("FROM com.albo.soa.model.ParteSuma ps WHERE ps.sync = :sync")
	List<ParteSuma> buscarPorSync(@Param("sync") boolean sync);

}
