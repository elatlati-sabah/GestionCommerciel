package com.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
