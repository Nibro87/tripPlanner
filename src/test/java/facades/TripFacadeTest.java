package facades;



import DTO.TripDTO;
import entities.Trip;
import errorhandling.NotFoundException;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TripFacadeTest {

    private static EntityManagerFactory emf;
    private static TripFacade facade;


    @BeforeAll
    public static void beforeAll(){

        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = TripFacade.getTripFacade(emf);
    }


    @AfterAll
    public static void tearDownClass(){

    }


    @BeforeEach
    public void setUP(){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();

            em.persist(new Trip("test","test","test","test","test","test"));
            em.getTransaction().commit();

        }finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown(){
    }

    @Test
    public void testGetAllTrips()  {

        List<TripDTO> actual = facade.getAllTrips();
        int expected = 1;

        assertEquals(expected,actual.size());


    }

    @Test
    public void allTrips(){

        List<TripDTO> tripDTOList= facade.getAllTrips();

        assertTrue(tripDTOList.size() > 0);

    }

}
