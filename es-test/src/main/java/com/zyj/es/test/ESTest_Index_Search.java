package com.zyj.es.test;

import com.zyj.es.utils.ESClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

/**
 * @program: ElasticSearch
 * @ClassName ESTest_Index_Create
 * @author: YaJun
 * @Date: 2021 - 11 - 23 - 19:50
 * @Package: com.zyj.es.test
 * @Description:
 */
public class ESTest_Index_Search {

    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = ESClient.getESClient();

        // 创建索引
        GetIndexRequest request = new GetIndexRequest("user");
        // 发送请求
        GetIndexResponse getIndexResponse = esClient.indices().get(request, RequestOptions.DEFAULT);


        // 响应状态
        // 获取索引别名
        System.out.println(getIndexResponse.getAliases());
        // 获取索引映射
        System.out.println(getIndexResponse.getMappings());
        System.out.println(getIndexResponse.getSettings());


        ESClient.closeESClient(esClient);
    }

}
