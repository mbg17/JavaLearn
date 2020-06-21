package test.Dao.Impl;

import JDBCTools.JdbcTool;
import Servlet.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import test.Dao.UserServletDao;
import test.Domain.PageBean;
import test.Domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserServletDaoImpl implements UserServletDao {
    private JdbcTemplate jdbc = new JdbcTemplate(JdbcTool.getFactory());

    /**
     * 查找所有用户
     * @return 用户列表
     */
    @Override
    public List<Student> findAll() {
        String sql = "select * from student";
        List<Student> query = jdbc.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        return query;
    }

    /**
     * 检测账号密码是否在数据库存在
     * @param name
     * @param password
     * @return 用户对象
     */
    @Override
    public User findUserByUsernameAndPassword(String name, String password) {
        var sql = "select * from user where username= ? and password = ?";
        try {
            User user = jdbc.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    name, password);
            return user;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    /**
     * 新增用户
     * @param student
     */
    @Override
    public void add(Student student) {
        var sql = "insert into student values (null,?,?,?,?,?,?)";
        jdbc.update(sql, student.getName(), student.getAge(), student.getGender(), student.getAddress(), student.getQq(), student.getEmail());
    }

    /**
     * 根据id删除指定用户
     * @param id
     */
    @Override
    public void del(String id) {
        var sql = "delete from student where id = ?";
        jdbc.update(sql,Integer.parseInt(id));
    }

    /**
     * 根据id返回用户封装对象
     * @param id
     */
    @Override
    public Student findUser(String id) {
        var sql = "select * from student where id = ?";
        try {
            Student st = jdbc.queryForObject(sql,
                    new BeanPropertyRowMapper<Student>(Student.class),
                    id);
            return st;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * 插入新用户
     * @param student
     */
    @Override
    public void update(Student student) {
        var sql = "update student set name=?,age=?,gender=?,address=?,qq=?,email=? where id=?";
        jdbc.update(sql,student.getName(),student.getAge(),student.getGender(),student.getAddress(),student.getQq(),student.getEmail(),student.getId());
    }

    /**
     * 根据id列表批量删除用户
     * @param uids
     */
    @Override
    public void delSelected(String[] uids) {
        if (uids!=null && uids.length>0){
            for (String uid : uids) {
                this.del(uid);
            }
        }
    }

    /**
     * 查询总记录数
     * @return 总记录数
     */
    @Override
    public int findTotalCount(Map<String, String[]> parameterMap) {
        var sql = new StringBuilder("select count(1) from student where 1=1");
        Set<String> strings = parameterMap.keySet();
        List<Object> params = new ArrayList<>();
        for (String string : strings) {
            String value = parameterMap.get(string)[0];
            if(string.equals("currentPage")){
                continue;
            }
            if(value!=null && !"".equals(value)){
                sql.append(" and "+string+" like ? ");
                params.add("%"+value+"%");
            }
        }
        Integer integer = jdbc.queryForObject(sql.toString(), Integer.class,params.toArray());
        return integer;
    }

    /**
     * 根据页码查询数据
     * @param currentPage
     * @param parameterMap
     * @return PageBean对象
     */
    @Override
    public PageBean<Student> findStudentByPage(String currentPage, Map<String, String[]> parameterMap) {
        PageBean<Student> pb = new PageBean<>();
        Set<String> strings = parameterMap.keySet();
        int pageNum;
        int totalCount = this.findTotalCount(parameterMap);
        List<Object> params = new ArrayList<>();
        int totalPages = (int) Math.ceil((double) totalCount/(double) pb.getRows());
        var sql = new StringBuilder("select * from student where 1=1");
        for (String string : strings) {
            String value = parameterMap.get(string)[0];
            if(string.equals("currentPage")){
                continue;
            }
            if(value!=null && !"".equals(value)){
                sql.append(" and "+string+" like ? ");
                params.add("%"+value+"%");
            }
        }
        sql.append(" limit ?,?");
        try {
            pageNum = Integer.parseInt(currentPage);
            if(pageNum<=0){
                pageNum=1;
            }else if(pageNum>totalPages){
                pageNum=totalPages;
            }
        }catch (Exception e){
            pageNum = 1;
        }
        int start = (pageNum-1)*pb.getRows();
        params.add(start);
        params.add(pb.getRows());
        List<Student> query = jdbc.query(sql.toString(), new BeanPropertyRowMapper<Student>(Student.class),params.toArray());
        pb.setCurrentPage(pageNum);
        pb.setList(query);
        pb.setTotalCount(totalCount);
        pb.setTotalPages(totalPages);
        return pb;
    }

}
