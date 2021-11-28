import com.zyj.es.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: ElasticSearch
 * @ClassName SpringDataESIndexTest
 * @author: YaJun
 * @Date: 2021 - 11 - 25 - 20:02
 * @Package: PACKAGE_NAME
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESIndexTest {

    // 注入ElasticsearchRestTemplate模板
    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void createIndex() {
        // 创建索引，系统初始化会读取实体类中@Document修饰的实体类，自动创建索引
        System.out.println("创建索引");
    }

    @Test
    public void deleteIndex() {
        // 删除索引
        boolean flag = elasticsearchRestTemplate.deleteIndex(Product.class);
        System.out.println("删除索引 = " + flag);
    }

}
