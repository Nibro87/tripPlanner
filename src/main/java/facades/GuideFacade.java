package facades;

import DTO.GuideDTO;
import entities.Guide;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class GuideFacade {

    private static EntityManagerFactory emf;
    private static GuideFacade instance;

    public GuideFacade() {
    }

    public static GuideFacade getGuideFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new GuideFacade();
        }
        return instance;
    }

    public Guide createGuide(Guide guide){


        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(guide);
            em.getTransaction().commit();

            return guide;
        }finally {
            em.close();
        }


    }



}
