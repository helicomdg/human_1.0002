package controller;

import entity.Klant;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import repository.KlantRepository;
import service.KlantService;
import java.util.List;

@Path("klant")
public class KlantController {
    private final KlantService klantService;
    public KlantController() {
        this.klantService = new KlantService();
    }

    @Path("klanten")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Klant> getKlanten(){
//        System.out.println("get Klanten");
        return klantService.getKlanten();
    }

//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getKlant(@PathParam("id") Long id) {
//        Klant klant = klantService.getKlantById(id);
//        if (klant != null) {
//            return Response.status(Response.Status.OK).entity(klant).build();
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//    }
//        @Path("{id}")
//        @GET
//        @Produces(MediaType.APPLICATION_JSON)
//        public Klant getKlant(@PathParam("id") Long id) {
//        return klantService.getKlant(id);
//        }
//@GET
//@Path("get/{id}")
//@Produces(MediaType.APPLICATION_JSON)
//public Response getKlantById(@PathParam("id") Long id) {
//    Klant klant = klantService.getKlant(id);
//    if (klant == null) {
//        return Response.status(Response.Status.NOT_FOUND).build();
//    }
//    return Response.ok(klant).build();
//}
    @Path("get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findKlantById(@PathParam("id") Long id) {
        Klant klant = klantService.findKlantByid(id);
        if (klant == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(klant).build();
        }
    }

//Werk niet need fix
//    @POST
//    @Path("create")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response addKlant(Klant klant) {
//        if (klant == null) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("fix null").build();
//        }
//        try {
//            Klant newKlant = klantService.addKlant(klant);
//            return Response.status(Response.Status.CREATED).entity(newKlant).build();
//        } catch (ConstraintViolationException e) {
//            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
//        }
//    }
//    @Path("create")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public Klant createKlant1(@FormParam("first_name") String first_name,
//                              @FormParam("last_name") String last_name,
//                              @FormParam("email") String email) {
//        return klantService.createKlant1(first_name, last_name, email);
//    }
    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createKlant(Klant klant) {
        Klant createdKlant = klantService.createKlant(klant);
        return Response.ok(createdKlant).build();
    }


    //Werk niet need fix
//    @PUT
//    @Path("update/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Klant updateKlant(@PathParam("id") Long id, Klant klant) {
//        return KlantService.updateKlant1(id, klant);
//    }
//    @Path("update")
//    @PUT
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateKlant1(@FormParam("id") Long id,
//                                @FormParam("first_name") String first_name,
//                                @FormParam("last_name") String last_name,
//                                @FormParam("email") String email) {
//        Klant klant = klantService.updateKlant1(id, first_name, last_name, email);
//        if (klant == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        } else {
//            return Response.ok(klant).build();
//        }
//    }
//    @Path("updateName")
//    @PUT
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateName(@QueryParam("id") Long id,
//                               @QueryParam("first_name") String first_name,
//                               @QueryParam("last_name") String last_name) {
//        Klant klant = klantService.updateName(id, first_name, last_name);
//        if (klant == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        } else {
//            return Response.ok(klant).build();
//        }
//    }
//    @Path("updateEmail")
//    @PUT
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateAdres(@QueryParam("id") Long id,
//                                @QueryParam("email") String email) {
//        Klant klant = klantService.updateEmail(id, email);
//        if (klant == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        } else {
//            return Response.ok(klant).build();
//        }
//    }
    @PUT
    @Path("put/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateKlant(@PathParam("id") Long id, Klant klant) {
        Klant existingKlant = klantService.getKlant(id);
        if (existingKlant == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        klant.setId(id);
        Klant updatedKlant = klantService.updateKlant(klant);
        return Response.ok(updatedKlant).build();
    }

    //Werk niet need fix
//    @DELETE
//    @Path("delete/{id}")
//    public void deleteKlant(@PathParam("id") Long id) {
//        klantService.removeKlant(id);
//    }
//    @Path("delete/{id}")
//    @DELETE
//    public Response delete(@PathParam("id") Long id) {
//        klantService.deleteKlant1(id);
//        return Response.noContent().build();
//    }
    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteKlant(@PathParam("id") Long id) {
        Klant klant = klantService.getKlant(id);
        if (klant == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        klantService.deleteKlant(klant);
        return Response.noContent().build();
    }
}






