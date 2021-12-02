package com.albo.controlop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albo.controlop.model.EstadoParte;

@Repository
public interface IEstadoParteRepository extends JpaRepository<EstadoParte, String> {

}
