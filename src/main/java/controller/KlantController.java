package controller;

import entity.Klant;
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

    @Path("getKlanten")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Klant> getKlanten(){
//        System.out.println("get Klanten");
        return klantService.getKlanten();
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addKlant(Klant klant) {
        if (klant == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("fix null").build();
        }
        try {
            Klant newKlant = klantService.addKlant(klant);
            return Response.status(Response.Status.CREATED).entity(newKlant).build();
        } catch (ConstraintViolationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKlant(@PathParam("id") Long id) {
        Klant klant = klantService.getKlantById(id);
        if (klant != null) {
            return Response.status(Response.Status.OK).entity(klant).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Klant updateKlant(@PathParam("id") Long id, Klant klant) {
        return KlantService.updateKlant1(id, klant);
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteKlant(@PathParam("id") Long id) {
        klantService.removeKlant(id);
    }

//        @Path("getKlant/{id}")
//        @GET
//        @Produces(MediaType.APPLICATION_JSON)
//        public Klant getKlant(@PathParam("id") Long id) {
//        return klantService.getKlant(id);
//        }

//    @Path("getKlant/{first_name}")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Klant> getKlanten(@PathParam("first name") String first_name) {
//        return klantService.getKlanten();
//    }


//        @Path("createKlant")
//        @POST
//        @Produces(MediaType.APPLICATION_JSON)
//        public Klant add(@FormParam("first name") String first_name,
//                              @FormParam("last name") String last_name,
//                              @FormParam("email") String email) {
//            return klantService.createKlant(first_name, last_name, email);
//        }

//    @Path("/findKlant/{first_name}")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findKlantByString(@PathParam("first_name") String first_name) {
//        Klant klant = klantService.getKlanten(klant.getFirst_name().equals(first_name));
//        if (klant == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        } else {
//            return Response.ok(klant).build();
//        }
//    }

//    @Path("removeKlant/{first_name}")
//    @DELETE
//    public Response deleteKlant(@PathParam("First_name") String first_name) {
//        klantService.deleteKlant(Klant klant);
//        return Response.noContent().build();
//    }


//    @Path("/updateKlant/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Klant> updateKlant(Long klantId,
//                                   @Valid Klant dataDetails) {
//        Klant klant = klantService.findById(klantId)
//                .orElseThrow(() -> new ResourceNotFoundException("Data not found with id " + klantId));
//        klant.setFirst_name(dataDetails.getFirst_name());
//        klant.setLast_name(dataDetails.getLast_name());
//        klant.setEmail(dataDetails.getEmail());
//
//        Klant updateKlant = klantService.updateKlant(klant);
//        return List.ok(updateKlant);
//    }

//    @Path("/deleteKlant/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Klant> deleteKlant(Long klantId) {
//        Klant klant = klantService.findById(klantId)
//                .orElseThrow(() -> new ResourceNotFoundException("Data not found with id " + klantId));
//        klantService.deleteKlant(klant);
//        return List.ok().build();
//    }

}
