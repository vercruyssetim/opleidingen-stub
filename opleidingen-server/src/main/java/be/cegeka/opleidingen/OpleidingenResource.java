package be.cegeka.opleidingen;

import be.cegeka.cursussen.CursusSearchResult;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static be.cegeka.opleidingen.Opleiding.OpleidingBuilder.anOpleiding;
import static java.util.stream.Collectors.toList;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Named
@Path("opleidingen")
public class OpleidingenResource {

    @Inject
    private OpleidingenService opleidingenService;

    @GET
    @Path("searchOpleiding")
    @Produces(APPLICATION_JSON)
    public Opleiding searchOpleiding(@QueryParam("id") String id){
        return opleidingenService.findOpleiding(id);
    }

    @PUT
    @Produces
    @Consumes(APPLICATION_JSON)
    @Path("opleiding")
    public void uploadSearchResultOpleidingen(OpleidingSearchResult opleidingSearchResult){
        opleidingenService.uploadSearchResultOpleidingen(opleidingSearchResult.hits.hits.stream()
                .map(opleidingStruct -> opleidingStruct._source)
                .collect(toList()));
    }

    @PUT
    @Produces
    @Consumes(APPLICATION_JSON)
    @Path("cursus")
    public void uploadSearchResultCursussen(CursusSearchResult cursusSearchResult){
        opleidingenService.uploadSearchResultCursussen(cursusSearchResult.hits.hits.stream()
                .map(cursusStruct -> cursusStruct._source)
                .collect(toList()));
    }
}
