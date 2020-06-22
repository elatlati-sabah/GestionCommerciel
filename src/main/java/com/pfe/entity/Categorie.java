package com.pfe.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id_categorie ;
	@Column
	private String libele;
	
	@OneToMany(mappedBy="categorie", fetch = FetchType.EAGER)
	private List<Produit> produits = new ArrayList<Produit>();

	public long getId_categorie() {
		return id_categorie;
	}

	public void setId_categorie(long id_categorie) {
		this.id_categorie = id_categorie;
	}

	public String getLibele() {
		return libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Categorie(long id_categorie, String libele, List<Produit> produits) {
		super();
		this.id_categorie = id_categorie;
		this.libele = libele;
		this.produits = produits;
	}

	public Categorie() {
		
	}
	
	
	
	
	

}
