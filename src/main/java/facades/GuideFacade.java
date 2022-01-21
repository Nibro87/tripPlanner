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

    public GuideDTO createGuide(GuideDTO guideDTO){

        Guide guide = new Guide(guideDTO);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(guide);
            em.getTransaction().commit();
        }finally {
            em.close();
        }

        return new GuideDTO(guide);
    }



}
