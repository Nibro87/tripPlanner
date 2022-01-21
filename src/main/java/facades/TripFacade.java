package facades;

import DTO.TripDTO;
import entities.Trip;
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


    public TripDTO deleteById(Long tripId){

        EntityManager em =emf.createEntityManager();

        Trip trip = em.find(Trip.class,tripId);

        if (trip == null){
            throw new WebApplicationException("no trips with that id");
        }

        try{
            em.getTransaction().begin();
            em.remove(trip);
            em.getTransaction().commit();
            return new TripDTO(trip);
        }finally {
            em.close();
        }


    }


    public TripDTO createTrip(TripDTO tripDTO){
        Trip trip = new Trip(tripDTO);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(trip);
            em.getTransaction().commit();

        }finally {
            em.close();
        }


        return new TripDTO(trip);
    }


}


