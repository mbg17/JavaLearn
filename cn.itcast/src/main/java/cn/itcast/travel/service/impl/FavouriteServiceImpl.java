package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavouriteDao;
import cn.itcast.travel.dao.impl.FavouriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.service.FavouriteService;
import org.springframework.cglib.proxy.Factory;

public class FavouriteServiceImpl implements FavouriteService {
    public final FavouriteDao favouriteDao = new FavouriteDaoImpl();
    @Override
    public boolean findByUidAndRid(int rid, int uid) {
        Favorite favorite = favouriteDao.hasFavourite(rid, uid);
        return favorite !=null;
    }

    @Override
    public int favouriteCount(int rid) {
        return favouriteDao.favouriteCount(rid);
    }

    @Override
    public boolean addFavourite(int uid, int rid) {
        return favouriteDao.addFavourite(uid,rid);
    }
}
