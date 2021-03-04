package com.cel.hibernatesandbox;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import com.hibernate.persistance.HibernatePersistence;

public class JeuTest
{
    private static Session session;
    @Test
    public void testUnionSubclass(){
        session = HibernatePersistence.getSessionFactory().openSession();
        session.beginTransaction();      

 
        JeuInterne jeuInterne = new JeuInterne();
        jeuInterne.setAgeGroupe("2+");
        jeuInterne.setNom("Jeu d'argile");
        jeuInterne.setNombreJoueurs(2);
 
        JeuExterne jeuExterne = new JeuExterne();
 
        jeuExterne.setNom("Cricket");
        jeuExterne.setSurfaceRequise("22 mètres");
 
        session.save(jeuInterne);
        session.save(jeuExterne);
 
        session.getTransaction().commit();
        session.close();
    }
}
