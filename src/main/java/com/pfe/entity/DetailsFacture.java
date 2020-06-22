package com.pfe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detailsfacture")
public class DetailsFacture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long idDetailsFacture;
	@Column
	private int quantite;
	@Column
	private float prixTTC;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_produit")
	private Produit produitfacture;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_facture")
	private Facture facture;
	public long getIdDetailsFacture() {
		return idDetailsFacture;
	}
	public void setIdDetailsFacture(long idDetailsFacture) {
		this.idDetailsFacture = idDetailsFacture;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getPrixTTC() {
		return prixTTC;
	}
	public void setPrixTTC(float prixTTC) {
		this.prixTTC = prixTTC;
	}
	public Produit getProduitfacture() {
		return produitfacture;
	}
	public void setProduitfacture(Produit produitfacture) {
		this.produitfacture = produitfacture;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public DetailsFacture() {
		
	}
	public DetailsFacture(long idDetailsFacture, int quantite, float prixTTC, Produit produitfacture, Facture facture) {
		super();
		this.idDetailsFacture = idDetailsFacture;
		this.quantite = quantite;
		this.prixTTC = prixTTC;
		this.produitfacture = produitfacture;
		this.facture = facture;
	}
	
	
}
