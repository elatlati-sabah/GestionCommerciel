package com.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Categorie;
import com.pfe.entity.Categorie;
import com.pfe.entity.Categorie;
import com.pfe.entity.Categorie;
import com.pfe.exception.ResourceNotFoundException;
import com.pfe.repository.CategorieRepository;
@Service
@Transactional
public class CategorieServiceImpl implements CategorieService{
	@Autowired
	private CategorieRepository categorieRepository;
	@Override
	public Categorie createCategorie(Categorie categorie) {
		return categorieRepository.save(categorie);
	}

	@Override
	public Categorie updateCategorie(Categorie categorie) {
Optional<Categorie> CategorieDb = this.categorieRepository.findById((long) categorie.getId_categorie());
		
		if(CategorieDb.isPresent()) {
			Categorie CategorieUpdate = CategorieDb.get();
			CategorieUpdate.setId_categorie(categorie.getId_categorie());
			CategorieUpdate.setLibele(categorie.getLibele());
			
			categorieRepository.save(CategorieUpdate);
			return CategorieUpdate;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +categorie.getId_categorie());
		}
	
	}

	@Override
	public List<Categorie> getAllCategorie() {
		return this.categorieRepository.findAll();
	}

	@Override
	public Categorie getCategorieById(long idCategorie) {
		Optional<Categorie> CategorieDb = this.categorieRepository.findById(idCategorie);
		
		if(CategorieDb.isPresent()) {
			return CategorieDb.get();
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idCategorie);
		}
	}

	@Override
	public void deleteCategorie(long idCategorie) {
		Optional<Categorie> CategorieDb = this.categorieRepository.findById(idCategorie);
		
		if(CategorieDb.isPresent()) {
			this.categorieRepository.delete(CategorieDb.get()) ;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idCategorie);
		}
	}

}
