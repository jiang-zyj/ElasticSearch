package com.zyj.es.utils;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @program: ElasticSearch
 * @ClassName ESClient
 * @author: YaJun
 * @Date: 2021 - 11 - 23 - 19:49
 * @Package: com.zyj.es.utils
 * @Description:
 */
public class ESClient {

    public static RestHighLevelClient getESClient() {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );
    }

    public static void closeESClient(RestHighLevelClient esClient) {
        try {
            esClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
