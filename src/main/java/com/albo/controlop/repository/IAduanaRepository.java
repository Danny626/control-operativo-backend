package com.albo.controlop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albo.controlop.model.Aduana;

@Repository
public interface IAduanaRepository extends JpaRepository<Aduana, Integer> {

}
