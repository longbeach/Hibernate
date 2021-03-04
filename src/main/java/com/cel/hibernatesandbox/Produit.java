package com.cel.hibernatesandbox;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
    private String code;
    private String nom;
    private BigDecimal prix;
    private Categorie categorie ;
    
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public BigDecimal getPrix() {
		return prix;
	}
	
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", code=" + code + ", nom=" + nom
				+ ", prix=" + prix + ", categorie=" + categorie + "]";
	} 
    
	
}