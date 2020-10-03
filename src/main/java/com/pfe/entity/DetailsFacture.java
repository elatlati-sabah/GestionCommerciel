package com.pfe.entity;

import javax.persistence.CascadeType;
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
	@JoinColumn(name = "id_facture")
	private Facture facture;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produit_deatils", referencedColumnName = "id_produit")
	private Produit produitDetails;
	
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
		this.prixTTC = quantite*produitfacture.getPrixUnitaire();
		
		this.facture = facture;
	}
	
	
	
	public Produit getProduitDetails() {
		return produitDetails;
	}
	public void setProduitDetails(Produit produitDetails) {
		this.produitDetails = produitDetails;
	}
	@Override
	public String toString() {
		return "DetailsFacture [idDetailsFacture=" + idDetailsFacture + ", quantite=" + quantite + ", prixTTC="
				+ prixTTC + ", facture=" + facture + "]";
	}
	
	
	
}