/*
 * The MIT License (MIT)
 * Copyright (c) 2016 Cegeka
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package be.cegeka.elasticsearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;

import java.io.IOException;
import java.util.List;

public abstract class AbstractElasticSearchRepository<TYPE extends ElasticSearchDocument> {

    private final String INDEX_NAME = "opleidingen";
    private final int MAX_NUMBER_OF_SEARCH_RESULTS = 50;

    protected final Client client;
    private final String typeName;
    private final Class<TYPE> type;
    private final ObjectMapper objectMapper;

    public AbstractElasticSearchRepository(Client client, String typeName, Class<TYPE> type){
        this.client = client;
        this.type = type;
        this.typeName = typeName;
        this.objectMapper = new ObjectMapper();
    }

    public void add(TYPE object){
        client.prepareIndex()
                .setIndex(INDEX_NAME)
                .setType(typeName)
                .setId(object.getId())
                .setSource(toJson(object))
                .get();
    }

    public List<SearchResult<TYPE>> findAll(){
        SearchResponse searchResponse = client.prepareSearch(INDEX_NAME)
                .setTypes(typeName)
                .execute()
                .actionGet();
        return toSearchResult(searchResponse);
    }

    public void delete(String id){
        client.prepareDelete()
                .setIndex(INDEX_NAME)
                .setType(typeName)
                .setId(id)
                .get();
    }

    public void dropIndex(){
        client.admin()
                .indices()
                .delete(new DeleteIndexRequest(INDEX_NAME))
                .actionGet();
    }

    public void initIndex(String index){
        client.admin().indices()
                .prepareCreate(INDEX_NAME)
                .setSource(index)
                .get();
    }

    public void updateMapping(String mapping){
        client.admin().indices()
                .preparePutMapping(INDEX_NAME)
                .setType(typeName)
                .setSource(mapping)
                .execute()
                .actionGet();
    }

    protected List<SearchResult<TYPE>> search(QueryBuilder queryBuilder){
        return toSearchResult(client.prepareSearch(INDEX_NAME)
                .setTypes(typeName)
                .setQuery(queryBuilder)
                .setSize(MAX_NUMBER_OF_SEARCH_RESULTS)
                .execute()
                .actionGet());
    }

    private List<SearchResult<TYPE>> toSearchResult(SearchResponse searchResponse){
        List<SearchResult<TYPE>> result = Lists.newArrayList();
        for(SearchHit searchHit: searchResponse.getHits().getHits()){
            result.add(new SearchResult<>(searchHit.getId(), searchHit.getScore(), toSearchResult(searchHit)));
        }
        return result;
    }

    private TYPE toSearchResult(SearchHit searchHit) {
        try {
            return objectMapper.readValue(searchHit.getSourceAsString(), type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] toJson(TYPE object) {
        try {
            return objectMapper.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
