package com.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Produit;
import com.pfe.exception.ResourceNotFoundException;
import com.pfe.repository.ProduitRepository;
@Service
@Transactional
public class ProduitServiceImpl implements ProduitService {
	@Autowired
	private ProduitRepository produitRepository;
	@Override
	public Produit createProduit(Produit produit) {
		return produitRepository.save(produit);
	}

	@Override
	public Produit updateProduit(Produit produit) {
		Optional<Produit> ProduitDb = this.produitRepository.findById((long) produit.getId_produit());
		
		if(ProduitDb.isPresent()) {
			Produit ProduitUpdate = ProduitDb.get();
			//ProduitUpdate.setIdProduit(produit.getId_produit());
			ProduitUpdate.setCodeProduit(produit.getCodeProduit());
			ProduitUpdate.setDesignation(produit.getDesignation());;
			ProduitUpdate.setInitialStock(produit.getInitialStock());
			ProduitUpdate.setPrixAchat(produit.getPrixAchat());
			ProduitUpdate.setLibelle(produit.getLibelle());
			ProduitUpdate.setPrixUnitaire(produit.getPrixUnitaire());
			ProduitUpdate.setQuantite(produit.getQuantite());
			produitRepository.save(ProduitUpdate);
			return ProduitUpdate;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +produit.getId_produit());
		}
	}

	@Override
	public List<Produit> getAllProduit() {
		return this.produitRepository.findAll();
	}

	@Override
	public Produit getProduitById(long idProduit) {
		Optional<Produit> ProduitDb = this.produitRepository.findById(idProduit);
		
		if(ProduitDb.isPresent()) {
			return ProduitDb.get();
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idProduit);
		}
	}

	@Override
	public void deleteProduit(long idProduit) {
		Optional<Produit> ProduitDb = this.produitRepository.findById(idProduit);
		
		if(ProduitDb.isPresent()) {
			this.produitRepository.delete(ProduitDb.get()) ;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idProduit);
		}
		
	}

}
