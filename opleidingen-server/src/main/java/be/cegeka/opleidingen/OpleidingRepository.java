package be.cegeka.opleidingen;

import jersey.repackaged.com.google.common.collect.ImmutableMap;

import javax.inject.Named;
import java.util.List;
import java.util.Map;

import static be.cegeka.opleidingen.Opleiding.OpleidingBuilder.anOpleiding;
import static java.util.stream.Collectors.toList;

@Named
public class OpleidingRepository {
    private Map<String, Opleiding> opleidingen = ImmutableMap.of(
            "bekister", anOpleiding().withName("bekister").build(),
            "lasser", anOpleiding().withName("lasser").build()
    );

    public List<Opleiding> findOpleidingen(String trefwoord) {
        return opleidingen.keySet().stream()
                .filter(key -> key.contains(trefwoord))
                .map(key -> opleidingen.get(key))
                .collect(toList());
    }
}
