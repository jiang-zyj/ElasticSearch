import com.zyj.es.dao.ProductDao;
import com.zyj.es.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ElasticSearch
 * @ClassName SpringDataESProductDaoTest
 * @author: YaJun
 * @Date: 2021 - 11 - 25 - 20:10
 * @Package: PACKAGE_NAME
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESProductDaoTest {

    @Resource
    private ProductDao productDao;


    /**
     * 保存操作
     */
    @Test
    private void save() {
        Product product = new Product();
        product.setId(2L);
        product.setTitle("华为手机");
        product.setCategory("手机");
        product.setPrice(2999.0);
        product.setImages("http://www.huawei.com");
        productDao.save(product);
    }

    /**
     * 更新操作
     */
    @Test
    private void update() {
        Product product = new Product();
        product.setId(2L);
        product.setTitle("小米手机");
        product.setCategory("手机");
        product.setPrice(4999.0);
        product.setImages("http://www.xiaomi.com");
        productDao.save(product);
    }

    /**
     * 根据id查询
     */
    @Test
    private void findById() {
        Product product = productDao.findById(2L).get();
        System.out.println(product);
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        Iterable<Product> products = productDao.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    /**
     * 删除
     */
    @Test
    public void delete() {
        Product product = new Product();
        product.setId(1L);
        productDao.delete(product);
    }

    /**
     * 批量保存数据
     */
    @Test
    public void saveAll() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId((long) i);
            product.setTitle("[" + i + "]号小米手机");
            product.setCategory("手机");
            product.setPrice(1999.0 + i);
            product.setImages("http://www.xiaomi.com");
            productList.add(product);
        }
        productDao.saveAll(productList);
    }

    /**
     * 分页查询
     */
    @Test
    public void findByPageable() {
        // 设置排序（排序方式，正序还是倒序，排序的id）
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        // 当前页，第一页从0开始，1表示第二页
        int from = 0;
        // 每页显示多少条
        int size = 5;

        // 设置查询分页
        PageRequest pageRequest = PageRequest.of(from, size, sort);
        // 分页查询
        Page<Product> productPage = productDao.findAll(pageRequest);
        for (Product product : productPage.getContent()) {
            System.out.println(product);
        }
    }


}
