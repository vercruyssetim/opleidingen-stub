package be.cegeka.cursussen;

import be.cegeka.elasticsearch.ElasticSearchDocument;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CursusElasticsearch implements ElasticSearchDocument{
    public String id;
    public String opleidingsCode;
    public boolean erkend;
    public Doelgroep doelgroep;

    @Override
    public String getId() {
        return id;
    }

    public static class Doelgroep {
        public String code;
        public String omschrijving;
    }
}
