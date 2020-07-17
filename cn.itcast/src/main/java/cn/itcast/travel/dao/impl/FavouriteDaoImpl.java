package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavouriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;

public class FavouriteDaoImpl implements FavouriteDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Favorite hasFavourite(int rid,int uid) {
        String sql = "select * from tab_favorite where uid=? and rid = ?";
        Favorite favorite = null;
        try{
            favorite=template.queryForObject(sql,new BeanPropertyRowMapper<Favorite>(Favorite.class),uid,rid);
        }catch (DataAccessException e){
        }
        return favorite;
    }

    @Override
    public int favouriteCount(int rid) {
        String sql = "select count(1) from tab_favorite where rid=?";
        return template.queryForObject(sql,Integer.class,rid);
    }

    @Override
    public boolean addFavourite(int rid, int uid) {
        Favorite favorite = this.hasFavourite(rid,uid);
        if(favorite == null){
            String sql = "insert into tab_favorite(rid,date,uid) values (?,?,?)";
            template.update(sql, rid, new Date(System.currentTimeMillis()), uid);
            return true;
        }else{
            return false;
        }
    }
}
