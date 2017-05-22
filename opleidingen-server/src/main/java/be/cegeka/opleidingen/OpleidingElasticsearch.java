package be.cegeka.opleidingen;

import be.cegeka.elasticsearch.ElasticSearchDocument;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpleidingElasticsearch implements ElasticSearchDocument {
    public String code;
    public String naam;
    public String getuigschrift;
    public String doelstelling;
    public String programma;
    public String attestering;

    @Override
    public String getId() {
        return code;
    }
}
