

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.cel.hibernatesandbox.Categorie;
import com.cel.hibernatesandbox.JeuExterne;
import com.cel.hibernatesandbox.JeuInterne;
import com.cel.hibernatesandbox.Produit;
import com.hibernate.persistance.HibernatePersistence;

public class MainTest {
	private static Session session;
    private static Categorie categorie;
    private static Produit produit;

    
    @Test
    public void testCategorie(){
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
    public void testProduit(){
        produit = new Produit();
        session = HibernatePersistence.getSessionFactory().openSession();
        produit.setNom("Chips");
        produit.setCode("C002");
        produit.setPrix(new BigDecimal("4.00"));
        produit.setCategorie(categorie);
        session.beginTransaction();
        
        Integer produitId =(Integer) session.save(produit);
        session.getTransaction().commit();
        produit = (Produit) session.get(Produit.class, produitId);
        
        assertEquals("Chips",produit.getNom());
        assertEquals(categorie.getId(), produit.getCategorie().getId());
    }
    
    //@Test
    public void testProduitNamedQuery(){
        session = HibernatePersistence.getSessionFactory().openSession();
        session.beginTransaction();
        
        Query query = session.getNamedQuery("toutesCategories");
        
        List<Categorie> categories = query.list();
        for(Categorie categorie : categories)
        {
         System.out.println(categorie);
        }
        assertEquals(0,categories.size());
        
        session.getTransaction().commit();
        session.close();
    }
    
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
