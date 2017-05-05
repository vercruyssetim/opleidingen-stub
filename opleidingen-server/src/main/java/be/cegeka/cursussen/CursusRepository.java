package be.cegeka.cursussen;

import be.cegeka.elasticsearch.AbstractElasticSearchRepository;
import be.cegeka.elasticsearch.SearchResult;
import be.cegeka.opleidingen.OpleidingElasticsearch;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;

import javax.inject.Named;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Named
public class CursusRepository extends AbstractElasticSearchRepository<CursusElasticsearch>{

    public CursusRepository(Client client) {
        super(client, "cursus", CursusElasticsearch.class);
    }

    public List<CursusElasticsearch> findCursussenByOpleidingsCode(String opleidingsCode) {
        return search(QueryBuilders.matchQuery("opleidingsCode", opleidingsCode)).stream()
                .map(SearchResult::getValue)
                .collect(toList());
    }
}
