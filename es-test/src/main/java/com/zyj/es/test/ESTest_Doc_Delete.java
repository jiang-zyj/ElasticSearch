package com.zyj.es.test;

import com.zyj.es.utils.ESClient;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @program: ElasticSearch
 * @ClassName ESTest_Index_Create
 * @author: YaJun
 * @Date: 2021 - 11 - 23 - 19:50
 * @Package: com.zyj.es.test
 * @Description:
 */
public class ESTest_Doc_Delete {

    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = ESClient.getESClient();

        // 删除数据
        DeleteRequest request = new DeleteRequest();
        request.index("user").id("1010");

        DeleteResponse response = esClient.delete(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult());

        ESClient.closeESClient(esClient);
    }

}
