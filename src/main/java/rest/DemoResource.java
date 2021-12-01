package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.Article;
import entities.Role;
import entities.User;
import java.util.List;
import java.util.concurrent.Future;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import errorhandling.API_Exception;
import facades.PostFacade;
import facades.UserFacade;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class DemoResource {

    private final UserFacade userFacade = UserFacade.getUserFacade(EMF);
    private final PostFacade postFacade = PostFacade.getPostFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    //Just to verify if the database is setup
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery ("select u from User u", User.class);
            List<User> users = query.getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public String getFromUser() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"" + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }

    @POST
    @Path("signup")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addUser(String jsonString){

        String username;
        String password;
        String email;

        JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
            username = json.get("username").getAsString();
            password = json.get("password").getAsString();
            email = json.get("email").getAsString();


            User user1 = new User(username,password,email);
            Role role = new Role("user");
            user1.addRole(role);
            User user = userFacade.createUser(user1);

            JsonObject responseJson = new JsonObject();
            responseJson.addProperty("username", username);

            return Response.ok(new Gson().toJson(responseJson)).build();


    }

    @POST
    @Path("share")
    @Produces("application/json")
    @Consumes("application/json")

    public Response addArticle(String jsonString){

        String urlToImage;
        String url;
        String title;
        String publishedAt;
        String description;
        String comment;

        JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();

        urlToImage = json.get("urlToImage").getAsString();
        url = json.get("url").getAsString();
        title = json.get("title").getAsString();
        publishedAt = json.get("publishedAt").getAsString();
        description = json.get("description").getAsString();
        comment = json.get("comment").getAsString();

        Article article1 = new Article(urlToImage,url,title,publishedAt,description,comment);

        Article article = postFacade.addArticle(article1);

        JsonObject responseJson = new JsonObject();
        responseJson.addProperty("url", url);


        return Response.ok(new Gson().toJson(responseJson)).build();
    }

    @GET
    @Path("/allposts")
    public Response getAllPosts(){

        return Response.ok(GSON.toJson(postFacade.getAllArticles()),"application/json").build();
    }

    @GET
    @Path("/delete")
    public void deleteArticle(@QueryParam("id") Long id){

        Article article = postFacade.deleteById(id);


    }


}