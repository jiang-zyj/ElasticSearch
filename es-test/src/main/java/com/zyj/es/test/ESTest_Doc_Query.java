package com.zyj.es.test;

import com.zyj.es.utils.ESClient;
import lombok.extern.log4j.Log4j;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

/**
 * @program: ElasticSearch
 * @ClassName ESTest_Index_Create
 * @author: YaJun
 * @Date: 2021 - 11 - 23 - 19:50
 * @Package: com.zyj.es.test
 * @Description:
 */
public class ESTest_Doc_Query {

    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = ESClient.getESClient();

        // 1. 查询索引中所有的数据
        //SearchRequest request = new SearchRequest();
        //request.indices("user");
        //
        //request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
        //
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}


        // 2. 条件查询 : termQuery
        //SearchRequest request = new SearchRequest();
        //request.indices("user");
        //
        //request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age", "19")));
        //
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}

        // 3. 分页查询
        //SearchRequest request = new SearchRequest();
        //request.indices("user");
        //
        //SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        //builder.from(2);
        //builder.size(2);
        //
        //request.source(builder);
        //
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}


        // 4. 查询排序
        //SearchRequest request = new SearchRequest();
        //request.indices("user");
        //
        //SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        //builder.sort("age", SortOrder.DESC);
        //
        //request.source(builder);
        //
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}

        // 5. 过滤字段
        //SearchRequest request = new SearchRequest();
        //request.indices("user");
        //
        //SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        //String[] excludes = {"age"};
        //String[] includes = {};
        //builder.fetchSource(includes, excludes);
        //
        //request.source(builder);
        //
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}


        // 6. 组合查询
        //SearchRequest request = new SearchRequest();
        //request.indices("user");
        //
        //SearchSourceBuilder builder = new SearchSourceBuilder();
        //BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        //
        ////boolQuery.must(QueryBuilders.matchQuery("sex", "男"));
        ////boolQuery.must(QueryBuilders.matchQuery("age", "19"));
        //boolQuery.should(QueryBuilders.matchQuery("sex", "男"));
        //boolQuery.should(QueryBuilders.matchQuery("age", "20"));
        //
        //builder.query(boolQuery);
        //
        //request.source(builder);
        //
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}

        // 7. 范围查询
        //SearchRequest request = new SearchRequest();
        //request.indices("user");
        //
        //SearchSourceBuilder builder = new SearchSourceBuilder();
        //RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
        //
        //rangeQuery.gte(20);
        //rangeQuery.lt(21);
        //
        //builder.query(rangeQuery);
        //
        //request.source(builder);
        //
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}


        // 8. 模糊查询
        //SearchRequest request = new SearchRequest();
        //request.indices("user");
        //
        //SearchSourceBuilder builder = new SearchSourceBuilder();
        //// 模糊查询，偏差距离可以为一个或多个 .fuzziness(Fuzziness.ONE)
        //FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name", "王五").fuzziness(Fuzziness.ONE);
        //
        //
        //builder.query(fuzzyQueryBuilder);
        //
        //request.source(builder);
        //
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}


        // 9. 高亮查询
        //SearchRequest request = new SearchRequest();
        //request.indices("user");
        //
        //SearchSourceBuilder builder = new SearchSourceBuilder();
        //TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("age", "20");
        //builder.query(termQueryBuilder);
        //
        //// 高亮设置
        //HighlightBuilder highlightBuilder = new HighlightBuilder();
        //highlightBuilder.preTags("<font color='red'>");
        //highlightBuilder.postTags("</font>");
        //highlightBuilder.field("name");
        //builder.highlighter(highlightBuilder);
        //
        //request.source(builder);
        //
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}


        // 10. 聚合查询
        //SearchRequest request = new SearchRequest();
        //request.indices("user");
        //
        //SearchSourceBuilder builder = new SearchSourceBuilder();
        //AvgAggregationBuilder avgAggregationBuilder = AggregationBuilders.avg("age_avg").field("age");
        //builder.aggregation(avgAggregationBuilder);
        //
        //
        //request.source(builder);
        //
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}

        // 11. 分组查询
        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("sex_group").field("sex");
        builder.aggregation(termsAggregationBuilder);


        request.source(builder);

        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        ESClient.closeESClient(esClient);
    }

}
