package com.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.entity.Societe;
@Repository
public interface SocieteRepository extends JpaRepository<Societe, Long>{

}
