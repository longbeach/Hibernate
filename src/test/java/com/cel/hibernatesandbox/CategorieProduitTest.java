package com.cel.hibernatesandbox;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.hibernate.persistance.HibernatePersistence;

public class CategorieProduitTest
{
    private static Session session;

    private static Categorie categorie;

    private static Produit produit;

    @Test
    @Order(1)
    public void testCategorie()
    {
        String nom = "Alimentation";
        categorie = new Categorie();
        session = HibernatePersistence.getSessionFactory().openSession();
        categorie.setNom(nom);
        session.beginTransaction();

        Integer categorieId = (Integer) session.save(categorie);
        session.getTransaction().commit();
        categorie = (Categorie) session.get(Categorie.class, categorieId);

        assertEquals("Alimentation", categorie.getNom());
    }

    @Test
    @Order(2)
    public void testProduit()
    {
        produit = new Produit();
        session = HibernatePersistence.getSessionFactory().openSession();
        produit.setNom("Chips");
        produit.setCode("C002");
        produit.setPrix(new BigDecimal("4.00"));
        produit.setCategorie(categorie);
        session.beginTransaction();

        Integer produitId = (Integer) session.save(produit);
        session.getTransaction().commit();
        produit = (Produit) session.get(Produit.class, produitId);

        assertEquals("Chips", produit.getNom());
        assertEquals(categorie.getId(), produit.getCategorie().getId());
    }

    @Disabled("Temporairement")
    @Test
    @Order(3)
    public void testProduitNamedQuery()
    {
        session = HibernatePersistence.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.getNamedQuery("toutesCategories");

        List<Categorie> categories = query.list();
        for (Categorie categorie : categories)
        {
            System.out.println(categorie);
        }
        assertEquals(0, categories.size());

        session.getTransaction().commit();
        session.close();
    }

}
