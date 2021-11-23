package com.zyj.es.test;

import com.alibaba.fastjson.JSON;
import com.zyj.es.entity.User;
import com.zyj.es.utils.ESClient;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
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
public class ESTest_Doc_Update {

    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = ESClient.getESClient();

        // 修改数据
        UpdateRequest request = new UpdateRequest();
        request.index("user").id("1010");

        request.doc(XContentType.JSON, "sex", "女", "age", "18");
        UpdateResponse response = esClient.update(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult());
        System.out.println(response.getShardId());
        System.out.println(response.getShardInfo());


        ESClient.closeESClient(esClient);
    }

}
