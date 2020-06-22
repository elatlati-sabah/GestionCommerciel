package com.pfe.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="fournisseur")
public class Fournisseur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id_fournisseur;
	@Column
	private String nom;
	@Column
	private String telephone;
	@Column
	private String adresse;
	@Column
	private String identifiant;
	
	@OneToMany(mappedBy="fournisseur")
	private List<Achat> achats = new ArrayList<Achat>();
	
	
	
	public Fournisseur(long id_fournisseur, String nom, String telephone, String adresse, String identifiant,
			List<Achat> achats) {
		super();
		this.id_fournisseur = id_fournisseur;
		this.nom = nom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.identifiant = identifiant;
		this.achats = achats;
	}
	
	
	public Fournisseur() {
		
	}


	public long getId_fournisseur() {
		return id_fournisseur;
	}
	public void setId_fournisseur(long id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public List<Achat> getAchats() {
		return achats;
	}
	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}
	
	
	
	
}
