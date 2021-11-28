package com.albo.controlop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albo.controlop.model.Recinto;

@Repository
public interface IRecintoRepository extends JpaRepository<Recinto, String> {

}
