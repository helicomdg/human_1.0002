package controller;

import entity.CarDealership;
import service.CarDealershipService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("dealership")
public class DealershipController {
    private final CarDealershipService service = new CarDealershipService();

    @GET
    @Path("info")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDealerships() {
        List<CarDealership> dealerships = service.getDealerships();
        return Response.ok(dealerships).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarDealershipById(@PathParam("id") Long id) {
        CarDealership dealership = service.getCarDealershipById(id);
        if (dealership == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(dealership).build();
        }
    }

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCarDealership(CarDealership carDealership) {
        CarDealership createdDealership = service.createCarDealership(carDealership);
        return Response.status(Response.Status.CREATED).entity(createdDealership).build();
    }

    @PUT
    @Path("put/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCarDealership(@PathParam("id") Long id, CarDealership carDealership) {
        carDealership.setId(Math.toIntExact(id));
        CarDealership updatedDealership = service.updateCarDealership(carDealership);
        return Response.ok(updatedDealership).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCarDealershipById(@PathParam("id") Long id) {
        boolean success = service.deleteCarDealershipById(id);
        if (success) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}

