package com.cel.hibernatesandbox;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import com.hibernate.persistance.HibernatePersistence;

public class JeuTest
{
    private static Session session;

    @Test
    public void testUnionSubclass()
    {
        session = HibernatePersistence.getSessionFactory().openSession();
        session.beginTransaction();

        JeuInterne jeuInterne = new JeuInterne();
        jeuInterne.setAgeGroupe("2+");
        jeuInterne.setNom("Jeu d'argile");
        jeuInterne.setNombreJoueurs(2);

        JeuExterne jeuExterne = new JeuExterne();

        jeuExterne.setNom("Cricket");
        jeuExterne.setSurfaceRequise("22 mètres");

        Integer jeuInterneId = (Integer) session.save(jeuInterne);
        Integer jeuExterneId = (Integer) session.save(jeuExterne);

        session.getTransaction().commit();

        JeuInterne jeuInterneTrouve = (JeuInterne) session.get(JeuInterne.class, jeuInterneId);
        assertEquals("Jeu d'argile", jeuInterneTrouve.getNom());

        JeuExterne jeuExterneTrouve = (JeuExterne) session.get(JeuExterne.class, jeuExterneId);
        assertEquals("Cricket", jeuExterneTrouve.getNom());

        
        session.close();
    }
}
