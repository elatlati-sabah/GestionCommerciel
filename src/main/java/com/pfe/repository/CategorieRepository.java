package com.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.entity.Categorie;
@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
