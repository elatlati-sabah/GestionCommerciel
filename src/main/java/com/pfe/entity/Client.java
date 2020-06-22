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
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long  id_client;
	@Column
	private String raisonSocial;
	@Column
	private String telephone;
	@Column
	private String adresse;
	@Column
	private String ice;
	@Column
	private String email;
	@Column
	private String nomContact;
	@OneToMany(mappedBy="client")
	private List<Facture> facture = new ArrayList<Facture>();
	@OneToMany(mappedBy="devisclient")
	private List<Devis> devis = new ArrayList<Devis>();
	
	public long getIdClient() {
		return id_client;
	}
	
	public void setIdClient(long idClient) {
		this.id_client = idClient;
	}
	public String getRaisonSocial() {
		return raisonSocial;
	}
	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
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
	public String getIce() {
		return ice;
	}
	public void setIce(String ice) {
		this.ice = ice;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomContact() {
		return nomContact;
	}
	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}
	public List<Facture> getFacture() {
		return facture;
	}
	public void setFacture(List<Facture> facture) {
		this.facture = facture;
	}

	public long getId_client() {
		return id_client;
	}

	public void setId_client(long id_client) {
		this.id_client = id_client;
	}

	public List<Devis> getDevis() {
		return devis;
	}

	public void setDevis(List<Devis> devis) {
		this.devis = devis;
	}

	public Client(long id_client, String raisonSocial, String telephone, String adresse, String ice, String email,
			String nomContact, List<Facture> facture, List<Devis> devis) {
		super();
		this.id_client = id_client;
		this.raisonSocial = raisonSocial;
		this.telephone = telephone;
		this.adresse = adresse;
		this.ice = ice;
		this.email = email;
		this.nomContact = nomContact;
		this.facture = facture;
		this.devis = devis;
	}

	public Client() {
		
	}
	
	
	
	
}
