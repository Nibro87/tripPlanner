package facades;

import entities.Article;
import entities.Comments;
import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import security.errorhandling.AuthenticationException;

import java.util.List;

/**
 * @author lam@cphbusiness.dk
 */
public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

    public User createUser (User user){

        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user;
        }finally {
            em.close();
        }

    }


   public Comments addComments (Comments comments){

       EntityManager em = emf.createEntityManager();

       try{

           em.getTransaction().begin();
           em.persist(comments);
           em.getTransaction().commit();
           return comments;

       }finally {
           em.close();
       }


    }

    public Article addArticle(Article article){

        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(article);
            em.getTransaction().commit();
            return article;
        }finally {
            em.close();
        }



    }




}
