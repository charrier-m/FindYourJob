package fr.apside.matis;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.io.File;
import java.net.URI;


@Path("/")
public class testService {

    @GET
    public Response getFirstPage() {
        File index = new File("C:/dev/FindYouJob/src/main/webapp/index.html");
        return Response.status(200).entity(index).build();
    }

    @GET
    @Path("/{name}")
    public Response getTestMessage(@PathParam("name") String name) {
        String greetings = "hi " + name;
        return Response.status(200).entity(greetings).build();
    }
}
