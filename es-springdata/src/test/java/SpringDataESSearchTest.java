import com.zyj.es.dao.ProductDao;
import com.zyj.es.entity.Product;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: ElasticSearch
 * @ClassName SpringDataESSearchTest
 * @author: YaJun
 * @Date: 2021 - 11 - 25 - 20:30
 * @Package: PACKAGE_NAME
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESSearchTest {

    @Resource
    private ProductDao productDao;

    /**
     * term 查询
     * search(termQueryBuilder) 调用搜索方法，参数查询构造器对象
     */
    @Test
    public void termQuery() {
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", "小米");
        Iterable<Product> products = productDao.search(termQueryBuilder);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    /**
     * term 查询加分页
     */
    @Test
    public void termQueryByPage() {
        int from = 0;
        int size = 5;

        // 设置查询分页
        PageRequest pageRequest = PageRequest.of(from, size);
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", "小米");
        Page<Product> products = productDao.search(termQueryBuilder, pageRequest);
        for (Product product : products) {
            System.out.println(product);
        }
    }

}
