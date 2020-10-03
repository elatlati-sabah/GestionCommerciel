package com.pfe.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detailsachat")
public class DetailsAchat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long idDetailsAchat;
	@Column
	private int quantite;
	@Column
	private double prix;
	@ManyToOne(fetch = FetchType.EAGER)
	private Achat achat ;
	@ManyToOne(fetch = FetchType.EAGER)
	private Produit produit ;
	public long getIdDetailsAchat() {
		return idDetailsAchat;
	}
	public void setIdDetailsAchat(long idDetailsAchat) {
		this.idDetailsAchat = idDetailsAchat;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Achat getAchat() {
		return achat;
	}
	public void setAchat(Achat achat) {
		this.achat = achat;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public DetailsAchat(long idDetailsAchat, int quantite, double prix, Achat achat, Produit produit) {
		super();
		this.idDetailsAchat = idDetailsAchat;
		this.quantite = quantite;
		this.prix = prix;
		this.achat = achat;
		this.produit = produit;
	}
	public DetailsAchat() {
		
	}
	
	
	
}