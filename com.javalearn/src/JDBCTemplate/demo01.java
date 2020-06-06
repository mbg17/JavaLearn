package JDBCTemplate;

import Druid.DruidTools;
import JDBC.Empolymee;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/*
JDBCTemplate 练习
 */
public class demo01 {
    JdbcTemplate jb = new JdbcTemplate(DruidTools.getFactory());
    // 修改1001员工的工资
    @Test
    public void test1(){
        String sql = "update emp set salary = ? where id = ?";
        int update = jb.update(sql, 10000, 1001);
        System.out.println(update);
    }
    // 插入新的数据
    @Test
    public void test2(){
        String sql = "insert into emp values (?,?,?,?,?,?,?,?)";
        int update = jb.update(sql,1017,"xixi",4,1004,new Date(20200522),20000,2000,20);
        System.out.println(update);
    }
    // 删除一条数据
    @Test
    public void test3(){
        String sql = "delete from emp where id = ?";
        int update = jb.update(sql,1017);
        System.out.println(update);
    }
    // 将查询结果封装成Map集合，只能查询单个结果
    @Test
    public void test4(){
        String sql = "select * from emp where id = ?";
        Map<String, Object> stringObjectMap = jb.queryForMap(sql, 1001);
        System.out.println(stringObjectMap);
    }
    // 将查询的每一个结果封窗成Map集合对象，然后加到list集合中
    @Test
    public void test5(){
        String sql = "select * from emp";
        List<Map<String, Object>> maps = jb.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
    // 将查到的每个对象封装成一个javabean对象，需要实现RowMapper接口或者已实现该接口的实现类（需要指定泛型，并传递泛型对象的Class对象）
    @Test
    public void test6(){
        String sql = "select * from emp";
        List<Empolymee> query = jb.query(sql, new BeanPropertyRowMapper<Empolymee>(Empolymee.class));
        for (Empolymee empolymee : query) {
            System.out.println(empolymee);
        }
    }
    // 将查询的结果封装成一个对象，需要指定返回对象的Class对象
    @Test
    public void test7(){
        String sql = "select count(1) from emp";
        Long aLong = jb.queryForObject(sql, long.class);
        System.out.println(aLong);
    }
}
