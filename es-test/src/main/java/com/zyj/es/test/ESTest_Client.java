package com.zyj.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @program: ElasticSearch
 * @ClassName ESTest_Client
 * @author: YaJun
 * @Date: 2021 - 11 - 22 - 22:38
 * @Package: com.zyj.es.test
 * @Description:
 */
public class ESTest_Client {

    public static void main(String[] args) throws Exception {

        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        // 关闭ES客户端
        esClient.close();

    }

}
