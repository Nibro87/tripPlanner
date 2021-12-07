package facades;


import entities.Comments;
import entities.SharedArticles;
import entities.User;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;
import entities.RenameMe;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class FacadeExampleTest {

    private static EntityManagerFactory emf;
    private static FacadeExample facade;
    private static UserFacade userFacade;
    private static PostFacade postFacade;
     SharedArticles sharedArticles;

    public FacadeExampleTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();

       facade = FacadeExample.getFacadeExample(emf);
      userFacade = UserFacade.getUserFacade(emf);
      postFacade = PostFacade.getPostFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();

    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testAFacadeMethod() {


    }

     @BeforeAll
     public static void addToDatabase(){

        EntityManager em = emf.createEntityManager();
        User user = new User("user2","test1","test@test.com");
         User user1 = new User("user1","test1","test@test.com");
        SharedArticles sharedArticles = new SharedArticles("test","test","test,test","test","test","test");
        SharedArticles sharedArticles1 = new SharedArticles("test","test","test,test","test","test","test");
        sharedArticles.setUser(user);
        sharedArticles1.setUser(user1);


     em.getTransaction().begin();
     em.persist(user);
     em.persist(user1);
     em.persist(sharedArticles);
     em.persist(sharedArticles1);
     em.getTransaction().commit();


    }

    @Disabled
    @Test
    public void addComments() {


        Comments expected = userFacade.addComments(new Comments(1L,"test1"));

       Comments actual = new Comments(1L,"test1");


        assertEquals(expected,actual);
    }

    @Test
    public void testArticleList(){

        List<SharedArticles> actual = postFacade.getAllArticles();

        int expected = 2;

        assertEquals(expected,actual.size());


    }

   @Disabled
    @Test
    public void testDeleteById(){

        SharedArticles actual = postFacade.deleteById(1L);

        SharedArticles expected = new SharedArticles(1L,"test","test","test,test","test","test","test");


        assertEquals(expected,actual);



    }


}
