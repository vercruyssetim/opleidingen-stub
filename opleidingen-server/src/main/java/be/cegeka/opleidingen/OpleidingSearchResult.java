package be.cegeka.opleidingen;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpleidingSearchResult {
    public Hits hits;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Hits {
        public List<OpleidingStruct> hits;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OpleidingStruct {
            public OpleidingElasticsearch _source;
        }
    }
}
