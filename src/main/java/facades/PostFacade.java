package facades;


import entities.Comments;
import entities.SharedArticles;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
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


    public Comments addComments(Comments comments) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.persist(comments);
            em.getTransaction().commit();
            return comments;

        } finally {
            em.close();
        }


    }


    public SharedArticles addArticle(SharedArticles article) {

        EntityManager em = emf.createEntityManager();
        ///User user = em.find(User.class,article.getUser());
        try {
            em.getTransaction().begin();
            em.persist(article);
            em.getTransaction().commit();
            return article;
        } finally {
            em.close();
        }


    }


    public List<SharedArticles> getAllArticles() {

        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<SharedArticles> query = em.createQuery("SELECT a from SharedArticles a", SharedArticles.class);
            List<SharedArticles> sharedArticlesList = query.getResultList();
            List<SharedArticles> ArticlesList = new ArrayList<>();
            for (SharedArticles c : sharedArticlesList) {
                ArticlesList.add(new SharedArticles(c, c.getUser()));
            }

            return ArticlesList;
        } finally {
            em.close();
        }


    }

    public SharedArticles deleteById(Long id) {

        EntityManager em = emf.createEntityManager();

        SharedArticles article = em.find(SharedArticles.class, id);
     ///   User user = em.find(User.class,article.getUser());

            try {
                em.getTransaction().begin();
                em.remove(article);
                em.getTransaction().commit();
                return article;
            } finally {
                em.close();

            }




    }

    public SharedArticles findById (Long id){

        EntityManager em = emf.createEntityManager();

        SharedArticles article = em.find(SharedArticles.class, id);


        return article;
    }

    }

