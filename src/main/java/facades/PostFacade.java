package facades;

import entities.Article;
import entities.Comments;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PostFacade {

    private static EntityManagerFactory emf;
    private static PostFacade instance;

    public PostFacade() {
    }

    public static PostFacade getPostFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PostFacade();
        }
        return instance;
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


    public List<Article> getAllArticles() {

        EntityManager em = emf.createEntityManager();

        try{
            TypedQuery<Article> query = em.createQuery("SELECT a from Article a",Article.class);
            return query.getResultList();

        }finally {
            em.close();
        }



    }

    public Article deleteById(Long id){

        EntityManager em = emf.createEntityManager();

        Article article = em.find(Article.class,id);

        if(article != null){

            em.getTransaction().begin();
            em.remove(article);
            em.getTransaction().commit();
        }


        return article;
    }



}
