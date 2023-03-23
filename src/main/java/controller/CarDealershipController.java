package controller;

import entity.CarDealership;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.CarDealershipService;

import java.util.List;

@Path("dealership")
public class CarDealershipController {
    private final CarDealershipService carDealershipService;
    public CarDealershipController() {
        this.carDealershipService = new CarDealershipService();
    }


    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CarDealership> getDealerships() {
        return carDealershipService.getDealerships();
    }

    @GET
    @Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCarDealershipById(@PathParam("id") int id) {
        CarDealership carDealership = carDealershipService.findCarDealershipByid(id);
        if (carDealership == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(carDealership).build();
        }
    }
    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCarDealership(CarDealership carDealership) {
        CarDealership createdCarDealership = carDealershipService.createCarDealership(carDealership);
        return Response.ok(createdCarDealership).build();
    }

    @PUT
    @Path("put/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCarDealership(@PathParam("id") int id, CarDealership carDealership) {
        CarDealership existingCarDealership = carDealershipService.getCarDealership(id);
        if (existingCarDealership == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        carDealership.setId(id);
        CarDealership updatedDealership = carDealershipService.updateCarDealership(carDealership);
        return Response.ok(updatedDealership).build();
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCarDealershipById(@PathParam("id") int id) {
        CarDealership carDealership = carDealershipService.getCarDealership(id);
        if (carDealership == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        carDealershipService.deleteCarDealership(carDealership);
        return Response.noContent().build();
    }
}

