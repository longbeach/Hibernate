package com.cel.hibernatesandbox;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import com.hibernate.persistance.HibernatePersistence;

public class JeuTest
{
    private static Session session;

    /*
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
    */
    
/*    
    @Test
    public void testUnionSubclassAvecFind()
    {
        session = HibernatePersistence.getSessionFactory().openSession();
        session.beginTransaction();
        List<JeuInterne> result = session.createQuery( "from JeuInterne" ).list();
        for ( JeuInterne jeuInterne : (List<JeuInterne>) result ) {
            System.out.println( "JeuInterne (" + jeuInterne.getNom() + ") : " + jeuInterne.getNombreJoueurs() );
        }
        
        assertEquals(0, result.size());
        
        session.getTransaction().commit();
        session.close();
    }
    */
    
    @Test
    public void testUnionSubclassAvecFind()
    {
        session = HibernatePersistence.getSessionFactory().openSession();
        session.beginTransaction();
        List<Jeu> result = session.createQuery( "from Jeu" ).list();
        for ( Jeu jeu : (List<Jeu>) result ) {
            System.out.println( "jeu (" + jeu.getNom() + ") : " + jeu.getId() );
        }
        
        assertEquals(0, result.size());
        
        session.getTransaction().commit();
        session.close();
    }

}
