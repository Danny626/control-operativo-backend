package com.albo.controlop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albo.controlop.model.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, String> {

}
