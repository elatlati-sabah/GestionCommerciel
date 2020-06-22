package com.pfe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="detailsdevis")
public class DetailsDevis {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long idDetailsDevis;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_produit")
	private Produit produitdevis;
	@Column
	private int quantite;
	@OneToOne
	private Devis idDevis;
	@Column
	private float prixTTC;
	public long getIdDetailsDevis() {
		return idDetailsDevis;
	}
	public void setIdDetailsDevis(long idDetailsDevis) {
		this.idDetailsDevis = idDetailsDevis;
	}
	public Produit getProduitdevis() {
		return produitdevis;
	}
	public void setProduitdevis(Produit produitdevis) {
		this.produitdevis = produitdevis;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Devis getIdDevis() {
		return idDevis;
	}
	public void setIdDevis(Devis idDevis) {
		this.idDevis = idDevis;
	}
	public float getPrixTTC() {
		return prixTTC;
	}
	public void setPrixTTC(float prixTTC) {
		this.prixTTC = prixTTC;
	}
	public DetailsDevis(long idDetailsDevis, Produit produitdevis, int quantite, Devis idDevis, float prixTTC) {
		super();
		this.idDetailsDevis = idDetailsDevis;
		this.produitdevis = produitdevis;
		this.quantite = quantite;
		this.idDevis = idDevis;
		this.prixTTC = prixTTC;
	}
	public DetailsDevis() {
		
	}
	
	
}
