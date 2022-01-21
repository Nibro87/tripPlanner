package rest;

import DTO.GuideDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.Gender;
import facades.GuideFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

@Path("guide")
public class GuideResource {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final GuideFacade guideFacade = GuideFacade.getGuideFacade(EMF);

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Guide ressource\"}";
    }


    @POST
    @Path("createguide")
    @Produces("application/json")
    @Consumes("application/json")

    public String createGuide (String jsonString){


        String name;
        String gender;
        String birthYear;
        String profil;
        String imgUrl;

        JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();

        name = json.get("name").getAsString();
        gender = json.get("gender").getAsString();
        birthYear = json.get("birthyear").getAsString();
        profil = json.get("profil").getAsString();
        imgUrl = json.get("imgurl").getAsString();


        GuideDTO guideDTO = new GuideDTO(name, Gender.valueOf(gender),birthYear,profil,imgUrl);
        GuideDTO response = guideFacade.createGuide(guideDTO);

        return GSON.toJson(response);

    }



}
