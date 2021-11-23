package com.zyj.es.test;

import com.zyj.es.utils.ESClient;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
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
public class ESTest_Doc_Get {

    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = ESClient.getESClient();

        // 查询数据
        GetRequest request = new GetRequest();
        request.index("user").id("1010");

        GetResponse response = esClient.get(request, RequestOptions.DEFAULT);

        System.out.println(response.getSourceAsString());


        ESClient.closeESClient(esClient);
    }

}
