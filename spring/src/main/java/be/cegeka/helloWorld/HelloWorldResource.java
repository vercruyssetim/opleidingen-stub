package be.cegeka.helloWorld;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Named
@Path("/hello")
public class HelloWorldResource {

    @GET
    @Path("/helloWorld")
    @Produces
    public String helloWorld(){
        return "hello world from server";
    }
}
