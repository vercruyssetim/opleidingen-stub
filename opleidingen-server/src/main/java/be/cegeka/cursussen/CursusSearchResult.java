package be.cegeka.cursussen;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class CursusSearchResult {
    public Hits hits;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Hits {
        public List<CursusStruct> hits;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class CursusStruct {
            public CursusElasticsearch _source;
        }
    }
}
