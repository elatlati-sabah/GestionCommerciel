package com.pfe.entity;


import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="societe")
public class Societe  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	@Column
	private String titreFrancais;
	@Column
	private Blob logo;
	@Column
	private String adresseFrancais;
	@Column
	private String telephone1;
	@Column
	private String telephone2;
	@Column
	private short TVA;
	@Column
	private String icen;
	@Column
	private String cnss;
	@Column
	private String patente ;
	@Column
	private String rc;
	@Column
	private String ifData;
	@Column
	private String cb;
	@Column
	private String login;
	@Column
	private String password;
	@Column
	private char activer;
	@Column
	private String serial;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitreFrancais() {
		return titreFrancais;
	}
	public void setTitreFrancais(String titreFrancais) {
		this.titreFrancais = titreFrancais;
	}
	public Blob getLogo() {
		return logo;
	}
	public void setLogo(Blob logo) {
		this.logo = logo;
	}
	public String getAdresseFrancais() {
		return adresseFrancais;
	}
	public void setAdresseFrancais(String adresseFrancais) {
		this.adresseFrancais = adresseFrancais;
	}
	public String getTelephone1() {
		return telephone1;
	}
	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}
	public String getTelephone2() {
		return telephone2;
	}
	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}
	public short getTVA() {
		return TVA;
	}
	public void setTVA(short tVA) {
		TVA = tVA;
	}
	public String getIcen() {
		return icen;
	}
	public void setIcen(String icen) {
		this.icen = icen;
	}
	public String getCnss() {
		return cnss;
	}
	public void setCnss(String cnss) {
		this.cnss = cnss;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getRc() {
		return rc;
	}
	public void setRc(String rc) {
		this.rc = rc;
	}
	public String getIfData() {
		return ifData;
	}
	public void setIfData(String ifData) {
		this.ifData = ifData;
	}
	public String getCb() {
		return cb;
	}
	public void setCb(String cb) {
		this.cb = cb;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getActiver() {
		return activer;
	}
	public void setActiver(char activer) {
		this.activer = activer;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	
	

}
