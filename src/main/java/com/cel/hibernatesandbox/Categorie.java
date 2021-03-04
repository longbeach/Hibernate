package com.cel.hibernatesandbox;

import java.util.HashSet;
import java.util.Set;

public class Categorie implements java.io.Serializable{

	private Integer id;
    private String nom;
    private Set<Produit> produitDetails = new HashSet<Produit>();
    
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Produit> getProduitDetails() {
		return produitDetails;
	}

	public void setProduitDetail(Set<Produit> produitDetails) {
		this.produitDetails = produitDetails;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", produitDetails="
				+ produitDetails + "]";
	}	
	
	
}
