package com.zyj.es.test;

import com.alibaba.fastjson.JSON;
import com.zyj.es.entity.User;
import com.zyj.es.utils.ESClient;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @program: ElasticSearch
 * @ClassName ESTest_Index_Create
 * @author: YaJun
 * @Date: 2021 - 11 - 23 - 19:50
 * @Package: com.zyj.es.test
 * @Description:
 */
public class ESTest_Doc_Insert {

    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = ESClient.getESClient();

        // 插入数据
        IndexRequest request = new IndexRequest();
        request.index("user").id("1010");

        // 构建对象
        User user = new User("zhangsan", "男", 20);
        // 向ES插入数据，必须将数据转换为JSON才可以
        String userJson = JSON.toJSONString(user);

        // 设置数据
        request.source(userJson, XContentType.JSON);

        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult());
        System.out.println(response.getShardId());
        System.out.println(response.getShardInfo());


        ESClient.closeESClient(esClient);
    }

}
