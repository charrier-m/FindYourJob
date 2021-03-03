package fr.apside.matis;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;


@Path("/qcm")
public class QcmREST {

    private QcmService qservice= new QcmService();
    private OnisepRepository jRep = new OnisepRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse() {
        return Response.status(200).entity(new UserQualitiesDTO()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response receiveQcmResult(UserQualitiesDTO dto) throws IOException, InterruptedException {
        OnisepDTO onisepDTO = jRep.askAPI(qservice.getDataFromStream(dto));
        return Response.status(200).entity(onisepDTO).build();
    }

}
