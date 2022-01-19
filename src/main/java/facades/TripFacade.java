package facades;

import DTO.TripDTO;
import errorhandling.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import java.util.List;

public class TripFacade {

    private static EntityManagerFactory emf;
    private static TripFacade instance;

    private TripFacade(){

    }

    public static TripFacade getTripFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new TripFacade();
        }
    return instance;
    }


    public List<TripDTO> getAllTrips() throws WebApplicationException {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<TripDTO> query = em.createQuery("SELECT t from trips t",TripDTO.class);
            List<TripDTO> tripDTOList = query.getResultList();
          if(tripDTOList.isEmpty()){
              throw new WebApplicationException("the database does not contain any items");
          }
            return tripDTOList;
        } finally {
            em.close();
        }



    }



}


