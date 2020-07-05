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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="versement")
public class Versement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id_versement;
	@Column
	private int cheque;
	@Column
	private int espece;
	@Column
	private String type_versement;
	@Column
	private int compteBancaire;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Client versementClient ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_facture")
	private Facture factureVersement;
	
	public long getId_versement() {
		return id_versement;
	}
	public void setId_versement(long id_versement) {
		this.id_versement = id_versement;
	}
	public int getCheque() {
		return cheque;
	}
	public void setCheque(int cheque) {
		this.cheque = cheque;
	}
	public int getEspece() {
		return espece;
	}
	public void setEspece(int espece) {
		this.espece = espece;
	}
	public String getType_versement() {
		return type_versement;
	}
	public void setType_versement(String type_versement) {
		this.type_versement = type_versement;
	}
	public int getCompteBancaire() {
		return compteBancaire;
	}
	public void setCompteBancaire(int compteBancaire) {
		this.compteBancaire = compteBancaire;
	}
	public Client getVersementClient() {
		return versementClient;
	}
	public void setVersementClient(Client versementClient) {
		this.versementClient = versementClient;
	}
	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Versement(long id_versement, int cheque, int espece, String type_versement, int compteBancaire,
			Client versementClient) {
		super();
		this.id_versement = id_versement;
		this.cheque = cheque;
		this.espece = espece;
		this.type_versement = type_versement;
		this.compteBancaire = compteBancaire;
		this.versementClient = versementClient;
	}
	
	
	public Facture getFactureVersement() {
		return factureVersement;
	}
	public void setFactureVersement(Facture factureVersement) {
		this.factureVersement = factureVersement;
	}
	@Override
	public String toString() {
		return "Versement [id_versement=" + id_versement + ", cheque=" + cheque + ", espece=" + espece
				+ ", type_versement=" + type_versement + ", compteBancaire=" + compteBancaire + ", versementClient="
				+ versementClient + "]";
	}
	
	
}
