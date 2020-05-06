package david.maisuradze.weather.controller;

import david.maisuradze.weather.model.DirectionType;
import david.maisuradze.weather.model.Weather;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/weather")
public class WeatherController {
    List<Weather> weathers = new ArrayList<>(Arrays.asList(
            new Weather("Tbilisi", 20, 15, 70, DirectionType.EAST, 20),
            new Weather("Batumi", 25, 11, 72, DirectionType.WEST, 20),
            new Weather("Kutaisi", 22, 12, 71, DirectionType.EAST, 20)
            ));

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Weather> weathers() {
        return weathers;
    }

    @GET
    @Path("/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public Weather cityWeather(@PathParam("city") String name){
        return weathers.stream().filter(c -> c.getCityName().equals(name)).findFirst().orElse(new Weather());
    }
}
