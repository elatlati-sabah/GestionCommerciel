package com.pfe.entity;

import java.sql.Date;

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
@Table(name="devis")
public class Devis {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long idDevis;
	@Column
	private Date dateDevis;
	@Column
	private String valider;
	@Column
	private String tva;
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int devisCounter;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_client")
	private Client devisclient ;
	public long getIdDevis() {
		return idDevis;
	}
	public void setIdDevis(long idDevis) {
		this.idDevis = idDevis;
	}
	public Date getDateDevis() {
		return dateDevis;
	}
	public void setDateDevis(Date dateDevis) {
		this.dateDevis = dateDevis;
	}
	public String getValider() {
		return valider;
	}
	public void setValider(String valider) {
		this.valider = valider;
	}
	public String getTva() {
		return tva;
	}
	public void setTva(String tva) {
		this.tva = tva;
	}
	public int getDevisCounter() {
		return devisCounter;
	}
	public void setDevisCounter(int devisCounter) {
		this.devisCounter = devisCounter;
	}
	public Client getDevisclient() {
		return devisclient;
	}
	public void setDevisclient(Client devisclient) {
		this.devisclient = devisclient;
	}
	public Devis(long idDevis, Date dateDevis, String valider, String tva, int devisCounter, Client devisclient) {
		super();
		this.idDevis = idDevis;
		this.dateDevis = dateDevis;
		this.valider = valider;
		this.tva = tva;
		this.devisCounter = devisCounter;
		this.devisclient = devisclient;
	}
	public Devis() {
		
	}
	
	
}