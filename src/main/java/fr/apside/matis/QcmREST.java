package fr.apside.matis;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Logger;

@Path("/qcm")
public class QcmREST {
    Logger logger = Logger.getLogger("logger from QcmService");

    //@Inject
    private QcmService qservice = new QcmService();

    //@Inject
    private OnisepRepository jRep = new OnisepRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse() {
        //return Response.status(200).entity("qcm page").build();
        return Response.status(200).entity(new UserQualitiesDTO()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response receiveQcmResult(UserQualitiesDTO dto) throws IOException, InterruptedException {
        String answer = jRep.askAPI(qservice.getDataFromStream(dto));
        logger.info("receive = " + dto.isMedical());
        logger.info("reponse de l'API" + answer);
        return Response.status(200).entity(answer).build();
    }
}
