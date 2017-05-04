package be.cegeka.opleidingen;

import org.springframework.context.annotation.Bean;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Named
@Path("opleidingen")
public class OpleidingenResource {

    @Inject
    private OpleidingRepository opleidingRepository;

    @GET
    @Path("searchOpleiding")
    @Produces(APPLICATION_JSON)
    public List<Opleiding> searchOpleiding(@QueryParam("trefwoord") String trefwoord){
        return opleidingRepository.findOpleidingen(trefwoord);
    }
}
