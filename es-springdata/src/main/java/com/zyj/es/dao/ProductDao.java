package com.zyj.es.dao;

import com.zyj.es.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: ElasticSearch
 * @ClassName ProductDao
 * @author: YaJun
 * @Date: 2021 - 11 - 25 - 19:56
 * @Package: com.zyj.es.dao
 * @Description:
 */
@Repository
public interface ProductDao extends ElasticsearchRepository<Product, Long> {



}
