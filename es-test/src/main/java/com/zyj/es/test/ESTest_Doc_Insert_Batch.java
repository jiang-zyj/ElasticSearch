package com.zyj.es.test;

import com.alibaba.fastjson.JSON;
import com.zyj.es.entity.User;
import com.zyj.es.utils.ESClient;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
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
public class ESTest_Doc_Insert_Batch {

    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = ESClient.getESClient();

        // 批量插入数据 翻译：bulk -> 散装，大批，大量       批量就是封装多个请求
        BulkRequest request = new BulkRequest();

        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "张三", "age", "19", "sex", "男"));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "李四", "age", "20", "sex", "女"));
        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "王五", "age", "21", "sex", "男"));
        request.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON, "name", "王五1", "age", "21", "sex", "男"));
        request.add(new IndexRequest().index("user").id("1005").source(XContentType.JSON, "name", "王五2", "age", "21", "sex", "男"));
        request.add(new IndexRequest().index("user").id("1006").source(XContentType.JSON, "name", "王五33", "age", "21", "sex", "男"));


        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);

        System.out.println(response.getTook());
        System.out.println(response.getItems());


        ESClient.closeESClient(esClient);
    }

}
