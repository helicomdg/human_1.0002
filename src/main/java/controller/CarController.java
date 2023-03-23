package controller;

import entity.Car;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.CarService;

@Path("car")
public class CarController {

    private CarService carService = new CarService();

    @GET
    @Path("cars")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCars() {
        return Response.ok(carService.getCars()).build();
    }

    @GET
    @Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCarById(@PathParam("id") Long id) {
        Car car = carService.getCarById(id);
        if (car == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(car).build();
    }

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCar(Car car) {
        Car newCar = carService.createCar(car);
        return Response.status(Response.Status.CREATED).entity(newCar).build();
    }

    @PUT
    @Path("put/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCar(@PathParam("id") Long id, Car car) {
        Car updatedCar = carService.updateCar1(id, car);
        if (updatedCar == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedCar).build();
    }

    @DELETE
    @Path("delete/{id}")
    public Response deleteCar(@PathParam("id") Long id) {
        boolean deleted = carService.deleteCarById(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }

}
