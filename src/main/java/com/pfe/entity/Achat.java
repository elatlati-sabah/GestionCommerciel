package com.pfe.entity;

import java.sql.Date;
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
@Table(name="achat")
public class Achat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id_achat;
	@Column
	private Date dateAchat ;
	@Column
	private String refAchat;
	@Column
	private String valider;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_fournisseur")
	private Fournisseur fournisseur ;
	
	@OneToMany(mappedBy="achat")
	private List<DetailsAchat> detailsachat = new ArrayList<DetailsAchat>();
	
	public Achat() {
		
	}
	
	
	
	public Achat(long id_achat, Fournisseur fournisseur, Date dateAchat, String refAchat, String valider) {
		super();
		this.id_achat = id_achat;
		this.fournisseur = fournisseur;
		this.dateAchat = dateAchat;
		this.refAchat = refAchat;
		this.valider = valider;
	}



	public long getId_achat() {
		return id_achat;
	}
	public void setId_achat(long id_achat) {
		this.id_achat = id_achat;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Date getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	public String getRefAchat() {
		return refAchat;
	}
	public void setRefAchat(String refAchat) {
		this.refAchat = refAchat;
	}
	public String getValider() {
		return valider;
	}
	public void setValider(String valider) {
		this.valider = valider;
	}



	public List<DetailsAchat> getDetailsachat() {
		return detailsachat;
	}



	public void setDetailsachat(List<DetailsAchat> detailsachat) {
		this.detailsachat = detailsachat;
	}



	@Override
	public String toString() {
		return "Achat [id_achat=" + id_achat + ", dateAchat=" + dateAchat + ", refAchat=" + refAchat + ", valider="
				+ valider + ", fournisseur=" + fournisseur + ", detailsachat=" + detailsachat + "]";
	}
	
	
	
	
	

}
