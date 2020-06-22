package com.pfe.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="societe")
public class Societe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	@Column
	private String titreFrancais;
	@Column
	private byte[] logo;
	@Column
	private double adresseFrancais;
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
	public void setId(long l) {
		this.id = l;
	}
	public String getTitreFrancais() {
		return titreFrancais;
	}
	public void setTitreFrancais(String titreFrancais) {
		this.titreFrancais = titreFrancais;
	}
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	public double getAdresseFrancais() {
		return adresseFrancais;
	}
	public void setAdresseFrancais(double adresseFrancais) {
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
	@Override
	public String toString() {
		return "Societe [id=" + id + ", titreFrancais=" + titreFrancais + ", logo=" + logo + ", adresseFrancais="
				+ adresseFrancais + ", telephone1=" + telephone1 + ", telephone2=" + telephone2 + ", TVA=" + TVA
				+ ", icen=" + icen + ", cnss=" + cnss + ", patente=" + patente + ", rc=" + rc + ", ifData=" + ifData
				+ ", cb=" + cb + ", login=" + login + ", password=" + password + ", activer=" + activer + ", serial="
				+ serial + "]";
	}
	public Societe(int id, String titreFrancais, byte[] logo, double adresseFrancais, String telephone1,
			String telephone2, short tVA, String icen, String cnss, String patente, String rc, String ifData, String cb,
			String login, String password, char activer, String serial) {
		super();
		this.id = id;
		this.titreFrancais = titreFrancais;
		this.logo = logo;
		this.adresseFrancais = adresseFrancais;
		this.telephone1 = telephone1;
		this.telephone2 = telephone2;
		TVA = tVA;
		this.icen = icen;
		this.cnss = cnss;
		this.patente = patente;
		this.rc = rc;
		this.ifData = ifData;
		this.cb = cb;
		this.login = login;
		this.password = password;
		this.activer = activer;
		this.serial = serial;
	}
	public Societe() {
	
	}
	
	
	
	

}
