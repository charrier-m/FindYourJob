package fr.apside.matis;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class OnisepRepository {

    String requestToAsk;

    Logger logger = Logger.getLogger("mylogger");


    metierLibelleDTO dto = new metierLibelleDTO();


   public String askAPI(String requestToAsk) throws IOException, InterruptedException {

        this.requestToAsk = requestToAsk;

        String url = "https://api.opendata.onisep.fr/api/1.0/dataset/5fa5949243f97/search?q="+requestToAsk;

        logger.info(url);
        URL onisepUrl = new URL(url);
        HttpURLConnection onisepConnection = (HttpURLConnection) onisepUrl.openConnection();
        onisepConnection.setRequestMethod("GET");
        //onisepConnection.setDoOutput(true);
        onisepConnection.connect();
        logger.info("request sent succesfully to onisep API");

        InputStream dataFlux = onisepConnection.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(dataFlux));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line=bf.readLine())!=null){
                sb.append(line);
            }
            bf.close();
            return sb.toString();

        //JsonReader jsonReader = Json.createReader(dataFlux);
        //JsonObject JsonResult = jsonReader.readObject();



    }


    /*

    @Path(value="/5fa5949243f97/search?q={path}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResultatFromOnisep(metierLibelleDTO dto){
        logger.info(dto.getLibelle_metier());
        return Response.status(200).build();
    }
*/

/*
    public metierLibelleDTO askAPI(String requestToAsk) {
        logger.info("request receive by metierLibelleDTO = " + requestToAsk);
        Client client = ClientBuilder.newClient();
        return client.target("https://api.opendata.onisep.fr/api/1.0/dataset")
                .path("5fa5949243f97/search?q=" + requestToAsk)
                .request(MediaType.APPLICATION_JSON)
                .header("content-type", MediaType.APPLICATION_JSON)
                .get(metierLibelleDTO);

    }
*/


}

