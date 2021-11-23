package com.zyj.es.test;

import com.zyj.es.utils.ESClient;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @program: ElasticSearch
 * @ClassName ESTest_Index_Create
 * @author: YaJun
 * @Date: 2021 - 11 - 23 - 19:50
 * @Package: com.zyj.es.test
 * @Description:
 */
public class ESTest_Doc_Delete_Batch {

    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = ESClient.getESClient();

        // 批量删除数据 翻译：bulk -> 散装，大批，大量       批量就是封装多个请求

        BulkRequest request = new BulkRequest();

        request.add(new DeleteRequest().index("user").id("1001"));
        request.add(new DeleteRequest().index("user").id("1002"));
        request.add(new DeleteRequest().index("user").id("1003"));

        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);

        System.out.println(response.getTook());
        System.out.println(response.getIngestTook());

        ESClient.closeESClient(esClient);
    }

}
