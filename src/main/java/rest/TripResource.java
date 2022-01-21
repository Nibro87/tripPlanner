package rest;

import DTO.GuideDTO;
import DTO.TripDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.Gender;
import entities.Guide;
import errorhandling.NotFoundException;
import facades.TripFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("trip")
public class TripResource {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final TripFacade tripFacade = TripFacade.getTripFacade(EMF);

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Trip ressource\"}";
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("alltrips")

    public Response allTrips() throws WebApplicationException {

       return Response.ok(GSON.toJson(tripFacade.getAllTrips()) ,"application/json").build();

    }

    @DELETE
    @Path("delete/{id}")
    @RolesAllowed("admin")
    public Response deleteTrip(@PathParam("id") Long id){

        TripDTO tripDTO = tripFacade.deleteById(id);

        return Response.ok(GSON.toJson(tripDTO) ,"application/json").build();
    }

    @POST
    @Path("createtrip")
    @Produces("application/json")
    @Consumes("application/json")

    public String createTrip(String jsonString){
        String tripname;
        String date;
        String time;
        String location;
        String duration;
        String packingList;

        JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();

        tripname = json.get("tripname").getAsString();
        date = json.get("date").getAsString();
        time = json.get("time").getAsString();
        location = json.get("location").getAsString();
        duration = json.get("duration").getAsString();
        packingList = json.get("packinglist").getAsString();

        TripDTO tripDto = new TripDTO(tripname,date,time,location,duration,packingList);
        TripDTO response = tripFacade.createTrip(tripDto);




        return GSON.toJson(response);

    }



}
