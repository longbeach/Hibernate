package com.cel.hibernatesandbox;

public class JeuInterne extends Jeu {
    
    private int nombreJoueurs;

    private String ageGroupe;

    public int getNombreJoueurs() {
       return nombreJoueurs;
    }

    public void setNombreJoueurs(int nombreJoueurs) {
       this.nombreJoueurs = nombreJoueurs;
    }
    public String getAgeGroupe() {
       return ageGroupe;
    }

    public void setAgeGroupe(String ageGroupe) {
       this.ageGroupe = ageGroupe;
    }
}
