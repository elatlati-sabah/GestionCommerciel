package com.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.entity.DetailsFacture;
@Repository
public interface DetailsFactureRepository extends JpaRepository<DetailsFacture, Long> {

}
