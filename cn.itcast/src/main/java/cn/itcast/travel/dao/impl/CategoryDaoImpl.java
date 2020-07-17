package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import cn.itcast.travel.util.JedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 陆远
 */
public class CategoryDaoImpl implements CategoryDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<Category> findAll() {
        Jedis jedis = JedisUtil.getJedis();
        String root = jedis.auth("root");
        List<Category> list = new ArrayList<>();
        Set<String> category = jedis.zrange("category",0,-1);
        try {
            if (category ==null || category.size() <= 0) {
                String sql = "select * from tab_category";
                list = template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
                for (Category c : list) {
                    jedis.zadd("category", c.getCid(),mapper.writeValueAsString(c));
                }
            } else {
                for (String s : category) {
                    list.add(mapper.readValue(s, Category.class));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        jedis.close();
        return list;
    }
}
