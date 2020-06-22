package com.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.entity.DetailsDevis;
@Repository
public interface DetailsDevisRepository extends JpaRepository<DetailsDevis, Long>{

}
