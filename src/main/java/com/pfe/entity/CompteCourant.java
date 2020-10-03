package com.pfe.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{

	private double decouvert;

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(String codeCompte, Date dateCreation, double solde, Societe societe, double decouvert) {
		super(codeCompte, dateCreation, solde, societe);
		this.decouvert = decouvert;
	}
	
	
	
	
	
	
}
