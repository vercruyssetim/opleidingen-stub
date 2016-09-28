package vlaanderen.vick.ai.algorithmia;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Named
@Path("/algorithmia")
public class AlgorithmiaResource {

    @GET
    @Path("/helloWorld")
    @Produces
    public String helloWorld(){
        return "hello world from server";
    }
}
