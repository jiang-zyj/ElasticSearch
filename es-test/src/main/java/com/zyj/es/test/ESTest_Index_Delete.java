package com.zyj.es.test;

import com.zyj.es.utils.ESClient;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
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
public class ESTest_Index_Delete {

    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = ESClient.getESClient();

        DeleteIndexRequest request = new DeleteIndexRequest("human");
        AcknowledgedResponse response = esClient.indices().delete(request, RequestOptions.DEFAULT);

        System.out.println(response.isAcknowledged());


        ESClient.closeESClient(esClient);
    }

}
