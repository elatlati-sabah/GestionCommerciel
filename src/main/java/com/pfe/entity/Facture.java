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

@Entity
@Table(name="facture")
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long  id_facture;
	@Column
	private Date dateFacturation;
	@Column
	private String valider;
	@Column
	private int tva;
	@Column
	private int factureCounter;
	
	@OneToMany(mappedBy="facture")
	private List<DetailsFacture> detailsfactures = new ArrayList<DetailsFacture>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_client")
	private Client client;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_produit")
	private Produit produitfact;
	
	/*@OneToMany(mappedBy="factureVersement", fetch = FetchType.EAGER)
	private List<Versement> versementFacture = new ArrayList<Versement>();*/
	
	public long getId_facture() {
		return id_facture;
	}
	public void setId_facture(long id_facture) {
		this.id_facture = id_facture;
	}
	public Date getDateFacturation() {
		return dateFacturation;
	}
	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}
	public String getValider() {
		return valider;
	}
	public void setValider(String valider) {
		this.valider = valider;
	}
	public int getTva() {
		return tva;
	}
	public void setTva(int tva) {
		this.tva = tva;
	}
	public int getFactureCounter() {
		return factureCounter;
	}
	public void setFactureCounter(int factureCounter) {
		this.factureCounter = factureCounter;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Facture(long id_facture, Date dateFacturation, String valider, int tva, int factureCounter,
			List<DetailsFacture> detailsfacture, Client client) {
		super();
		this.id_facture = id_facture;
		this.dateFacturation = dateFacturation;
		this.valider = valider;
		this.tva = tva;
		this.factureCounter = factureCounter;
		this.detailsfactures = detailsfacture;
		this.client = client;
	}
	public Facture() {
		
	}
	
	public List<DetailsFacture> getDetailsfactures() {
		return detailsfactures;
	}
	public void setDetailsfactures(List<DetailsFacture> detailsfactures) {
		this.detailsfactures = detailsfactures;
	}
	public Produit getProduitfact() {
		return produitfact;
	}
	public void setProduitfact(Produit produitfact) {
		this.produitfact = produitfact;
	}
	
	/*public List<Versement> getVersementFacture() {
		return versementFacture;
	}
	public void setVersementFacture(List<Versement> versementFacture) {
		this.versementFacture = versementFacture;
	}*/
	@Override
	public String toString() {
		return "Facture [id_facture=" + id_facture + ", dateFacturation=" + dateFacturation + ", valider=" + valider
				+ ", tva=" + tva + ", factureCounter=" + factureCounter + ", detailsfactures=" + detailsfactures
				+ ", client=" + client + ", produitfact=" + produitfact + "]";
	}
	
	
}
