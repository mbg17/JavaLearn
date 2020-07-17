package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

public interface FavouriteDao {
    public Favorite hasFavourite(int uid,int rid);

    public int favouriteCount(int rid);

    public boolean addFavourite(int uid,int rid);
}
