package controller;

import entity.Klant;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.KlantService;
import java.awt.*;
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
}
