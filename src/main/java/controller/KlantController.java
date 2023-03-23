package controller;

import entity.Klant;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
    public List<Klant> getKlanten() {
//        System.out.println("get Klanten");
        return klantService.getKlanten();
    }

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

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createKlant(Klant klant) {
        Klant createdKlant = klantService.createKlant(klant);
        return Response.ok(createdKlant).build();
    }

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






