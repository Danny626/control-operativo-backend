package com.albo.controlop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albo.controlop.model.ParteSuma;

@Repository
public interface IParteSumaRepository extends JpaRepository<ParteSuma, Long> {

}
