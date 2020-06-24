package com.pfe.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="produit")
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id_produit;
	@Column
	private String libelle;
	@Column
	private String designation;
	@Column
	private int prixUnitaire;
	@Column
	private String codeProduit;
	@Column
	private int initialStock;
	@Column
	private int quantite;
	@Column
	private double prixAchat;
	@JsonIgnore
	@OneToMany(mappedBy = "produit")
	private List<DetailsAchat> detailachat = new ArrayList<DetailsAchat>();
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_categorie")
	private Categorie categorie;
	@JsonIgnore
	@OneToMany(mappedBy = "produitfacture")
	private List<DetailsFacture> detailfactures = new ArrayList<DetailsFacture>();
	@JsonIgnore
	@OneToMany(mappedBy = "produitdevis")
	private List<DetailsDevis> detaildevis = new ArrayList<DetailsDevis>();
	@JsonIgnore
	@OneToMany(mappedBy = "produitfact")
	private List<Facture> factures = new ArrayList<Facture>();
	
	public long getId_produit() {
		return id_produit;
	}

	public void setId_produit(long id_produit) {
		this.id_produit = id_produit;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}


	public int getInitialStock() {
		return initialStock;
	}

	public void setInitialStock(int initialStock) {
		this.initialStock = initialStock;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public List<DetailsAchat> getDetailachat() {
		return detailachat;
	}

	public void setDetailachat(List<DetailsAchat> detailachat) {
		this.detailachat = detailachat;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<DetailsFacture> getDetailfacture() {
		return detailfactures;
	}

	public void setDetailfacture(List<DetailsFacture> detailfacture) {
		this.detailfactures = detailfacture;
	}

	public List<DetailsDevis> getDetaildevis() {
		return detaildevis;
	}

	public void setDetaildevis(List<DetailsDevis> detaildevis) {
		this.detaildevis = detaildevis;
	}

	public Produit(long id_produit, String libelle, String designation, int prixUnitaire, String codeProduit,
			Categorie idCategorie, int initialStock, int quantite, double prixAchat, List<DetailsAchat> detailachat,
			Categorie categorie, List<DetailsFacture> detailfacture, List<DetailsDevis> detaildevis) {
		super();
		this.id_produit = id_produit;
		this.libelle = libelle;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.codeProduit = codeProduit;
		this.initialStock = initialStock;
		this.quantite = quantite;
		this.prixAchat = prixAchat;
		this.detailachat = detailachat;
		this.categorie = categorie;
		this.detailfactures = detailfacture;
		this.detaildevis = detaildevis;
	}

	public Produit() {
		
	}

	@Override
	public String toString() {
		return "Produit [id_produit=" + id_produit + ", libelle=" + libelle + ", designation=" + designation
				+ ", prixUnitaire=" + prixUnitaire + ", codeProduit=" + codeProduit + ", initialStock=" + initialStock
				+ ", quantite=" + quantite + ", prixAchat=" + prixAchat + ", detailachat=" + detailachat
				+ ", categorie=" + categorie + ", detailfacture=" + detailfactures + ", detaildevis=" + detaildevis
				+ "]";
	}

	public List<DetailsFacture> getDetailfactures() {
		return detailfactures;
	}

	public void setDetailfactures(List<DetailsFacture> detailfactures) {
		this.detailfactures = detailfactures;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	
	
}
