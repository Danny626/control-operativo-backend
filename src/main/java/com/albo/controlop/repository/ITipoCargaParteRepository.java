package com.albo.controlop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albo.controlop.model.TipoCargaParte;

@Repository
public interface ITipoCargaParteRepository extends JpaRepository<TipoCargaParte, String> {

}
