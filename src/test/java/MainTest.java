

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.hibernate.persistance.HibernatePersistence;
import com.hibernate.tutorial.Category;
import com.hibernate.tutorial.IndoorGame;
import com.hibernate.tutorial.OutdoorGame;
import com.hibernate.tutorial.Product;

/**
 * Unit test for simple App.
 */
public class MainTest {
	private static Session session;
    private static Category category;
    private static Product product;

    
    @Test
    public void testCategory(){
        String name = "Penalty";
        category = new Category();
        session = HibernatePersistence.getSessionFactory().openSession();
        category.setName(name);
        session.beginTransaction();
        
        Integer categoryId = (Integer) session.save(category);
        session.getTransaction().commit();
        category = (Category) session.get(Category.class, categoryId);
        
        assertEquals("Penalty", category.getName());
    }
    
    @Test
    public void testProduct(){
        product = new Product();
        session = HibernatePersistence.getSessionFactory().openSession();
        product.setName("COKE");
        product.setCode("C002");
        product.setPrice(new BigDecimal("18.00"));
        product.setCategory(category);
        session.beginTransaction();
        
        Integer productId =(Integer) session.save(product);
        session.getTransaction().commit();
        product = (Product) session.get(Product.class, productId);
        
        assertEquals("COKE",product.getName());
        assertEquals(category.getId(), product.getCategory().getId());
    }
    
    //@Test
    public void testProductNamedQuery(){
        session = HibernatePersistence.getSessionFactory().openSession();
        session.beginTransaction();
        
        Query query = session.getNamedQuery("toutesCategories");
        
        List<Category> categories = query.list();
        for(Category category : categories)
        {
         System.out.println(category);
        }
        assertEquals(0,categories.size());
        
        session.getTransaction().commit();
        session.close();
    }
    
    @Test
    public void testUnionSubclass(){
        session = HibernatePersistence.getSessionFactory().openSession();
        session.beginTransaction();      

 
        IndoorGame indoorGame = new IndoorGame();
        indoorGame.setAgeGroup("2+");
        indoorGame.setName("Clay Game");
        indoorGame.setNumberOfPlayers(2);
 
        OutdoorGame outdoorGame = new OutdoorGame();
 
        outdoorGame.setName("Cricket");
        outdoorGame.setRequiredArea("22 yards");
 
        session.save(indoorGame);
        session.save(outdoorGame);
 
        session.getTransaction().commit();
        session.close();
    }
    
    
   
}
