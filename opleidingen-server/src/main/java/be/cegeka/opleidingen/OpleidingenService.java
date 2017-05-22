package be.cegeka.opleidingen;

import be.cegeka.cursussen.CursusElasticsearch;
import be.cegeka.cursussen.CursusRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

import static be.cegeka.opleidingen.Opleiding.OpleidingBuilder.anOpleiding;

@Named
public class OpleidingenService {

    @Inject
    private OpleidingRepository opleidingRepository;

    @Inject
    private CursusRepository cursusRepository;

    public Opleiding findOpleiding(String id) {
        OpleidingElasticsearch opleidingElasticsearch = opleidingRepository.findOpleidingenById(id).get(0);
        List<CursusElasticsearch> cursussen = cursusRepository.findCursussenByOpleidingsCode(id);


        return anOpleiding()
                .withId(opleidingElasticsearch.getId())
                .withName(opleidingElasticsearch.naam)
                .withGetuigschrift(opleidingElasticsearch.getuigSchrift)
                .withDoelstelling(opleidingElasticsearch.doelstelling)
                .withProgramma(opleidingElasticsearch.programma)
                .withAttestering(opleidingElasticsearch.attestering)
                .withDoelgroep(hasAtLeastOnceDoelgroepZelfstandige(cursussen) ? "Zelfstandige" : "Other")
                .withErkend(cursussen.stream().anyMatch(cursusElasticsearch -> cursusElasticsearch.erkend))
                .build();
    }

    private boolean hasAtLeastOnceDoelgroepZelfstandige(List<CursusElasticsearch> cursussen) {
        return cursussen.stream()
                .anyMatch(cursusElasticsearch -> cursusElasticsearch.doelgroep.code.equals("1"));
    }

    public void uploadSearchResultOpleidingen(List<OpleidingElasticsearch> opleidingen) {
        opleidingen.stream().forEach(opleiding -> opleidingRepository.add(opleiding));
    }

    public void uploadSearchResultCursussen(List<CursusElasticsearch> cursussen) {
        cursussen.stream().forEach(cursus -> cursusRepository.add(cursus));
    }

    public void dropIndex() {
        opleidingRepository.dropIndex();
    }
}
