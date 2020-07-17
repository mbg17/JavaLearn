package cn.itcast.travel.service;

public interface FavouriteService {
    public boolean findByUidAndRid(int uid,int rid);

    public int favouriteCount(int rid);

    public boolean addFavourite(int uid,int rid);
}
