package be.cegeka.opleidingen;

import be.cegeka.elasticsearch.AbstractElasticSearchRepository;
import be.cegeka.elasticsearch.SearchResult;
import jersey.repackaged.com.google.common.collect.ImmutableMap;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import javax.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static be.cegeka.opleidingen.Opleiding.OpleidingBuilder.anOpleiding;
import static java.util.stream.Collectors.toList;

@Named
public class OpleidingRepository extends AbstractElasticSearchRepository<OpleidingElasticsearch>{

    public OpleidingRepository(Client client) {
        super(client, "opleiding", OpleidingElasticsearch.class);
    }

    public List<OpleidingElasticsearch> findOpleidingenById(String id) {
        return search(QueryBuilders.matchQuery("code", id)).stream()
                .map(SearchResult::getValue)
                .collect(toList());
    }
}
