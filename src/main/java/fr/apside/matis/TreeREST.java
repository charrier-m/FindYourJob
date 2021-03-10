package fr.apside.matis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

@Path("/tree")
public class TreeREST {
    Logger logger = LoggerFactory.getLogger(TreeREST.class);
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTree(){
        logger.info("get request received");
        File Tree = new File("C:/dev/FindYouJob/src/main/resources/tree.json");
        return Response.status(200).entity(Tree).build();
    }
}
