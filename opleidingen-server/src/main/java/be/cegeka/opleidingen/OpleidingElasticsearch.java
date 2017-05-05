package be.cegeka.opleidingen;

import be.cegeka.elasticsearch.ElasticSearchDocument;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpleidingElasticsearch implements ElasticSearchDocument{
    public String code;
    public String naam;
    public String getuigSchrift;

    @Override
    public String getId() {
        return code;
    }
}
