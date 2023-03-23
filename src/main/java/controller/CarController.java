package controller;

import entity.Car;
import entity.Klant;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.CarService;
import java.util.List;
@Path("car")
public class CarController {
    private final CarService carService;
    public CarController() { this.carService = new CarService(); }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCars() {
//        System.out.println("get Cars");
        return carService.getCars();
    }
    @GET
    @Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCarById(@PathParam("id") int id) {
        Car car = carService.findCarByid(id);
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
        Car createdCar = carService.createCar(car);
        return Response.status(Response.Status.CREATED).entity(createdCar).build();
    }
    @PUT
    @Path("put/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCar(@PathParam("id") int id, Car car) {
        Car existingCar = carService.getCar(id);
        if (existingCar == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        car.setId(id);
        Car updatedCar = carService.updateCar(car);
        return Response.ok(updatedCar).build();
    }
    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCar(@PathParam("id") int id) {
        Car car = carService.getCar(id);
        if (car == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
