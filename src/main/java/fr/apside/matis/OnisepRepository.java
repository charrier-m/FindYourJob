package fr.apside.matis;

import org.glassfish.jersey.client.ClientConfig;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

public class OnisepRepository {

    Logger logger = Logger.getLogger("mylogger");

    public OnisepDTO askAPI(String requestToAsk) {

        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);

        OnisepDTO response = client.target("https://api.opendata.onisep.fr/api/1.0/dataset/5fa5949243f97/search?q="+requestToAsk)
                .request(MediaType.APPLICATION_JSON)
                .header("content-type", MediaType.APPLICATION_JSON)
                .get(OnisepDTO.class);

        logger.info(response.toString());

        return response;
    }

}





