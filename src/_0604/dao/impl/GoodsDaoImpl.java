package _0604.dao.impl;

import _0604.dao.BaseDao;
import _0604.dao.GoodsCartDao;
import _0604.dao.GoodsDao;
import _0604.pojo.Goods;
import _0604.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunyong
 * @date 2020/06/04
 * @description
 */
public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    //买家模糊查询商品
    @Override
    public List<Goods> queryGoodsByName(String name) throws SQLException {
        List<Goods> list = null;
        String sql = "select * from goods where goodsName like '%"+name+"%'";
        ResultSet rs=executeSQL(sql);
        boolean flag =true;
        while (rs.next()){
            if(flag){
                list=new ArrayList<>();
                flag=false;
            }
            Goods goods = new Goods();
            goods.setGoodsId(rs.getInt(1));
            goods.setGoodsName(rs.getString(2));
            goods.setPrice(rs.getDouble(3));
            goods.setStoreNum(rs.getInt(4));
            goods.setGoodsStatus(rs.getString(5));
            goods.setShopId(rs.getInt(6));
            goods.setGoodsDescription(rs.getString(7));
            list.add(goods);
        }
        return list;
    }
//    根据商家id查看该商家名下所有的商品
    @Override
    public List<Goods> queryAll(User user) throws SQLException {
        List<Goods> list = null;
        String sql = "select * from goods where shopId = " +user.getUid() ;
        ResultSet rs=executeSQL(sql);
        boolean flag =true;
        while (rs.next()){
            if(flag){
                list=new ArrayList<>();
                flag=false;
            }
            Goods goods = new Goods();
            goods.setGoodsId(rs.getInt(1));
            goods.setGoodsName(rs.getString(2));
            goods.setPrice(rs.getDouble(3));
            goods.setStoreNum(rs.getInt(4));
            goods.setGoodsStatus(rs.getString(5));
            goods.setShopId(rs.getInt(6));
            goods.setGoodsDescription(rs.getString(7));
            list.add(goods);
        }
        return list;
    }
    //买家查看所有商品
    @Override
    public List<Goods> queryAll() throws SQLException {
        List<Goods> list = null;
        String sql = "select * from goods";
        ResultSet rs=executeSQL(sql);
        boolean flag =true;
        while (rs.next()){
            if(flag){
                list=new ArrayList<>();
                flag=false;
            }
            Goods goods = new Goods();
            goods.setGoodsId(rs.getInt(1));
            goods.setGoodsName(rs.getString(2));
            goods.setPrice(rs.getDouble(3));
            goods.setStoreNum(rs.getInt(4));
            goods.setGoodsStatus(rs.getString(5));
            goods.setShopId(rs.getInt(6));
            goods.setGoodsDescription(rs.getString(7));
            list.add(goods);
        }
        return list;
    }

    @Override
    public List<Goods> queryAll1() throws SQLException {
        List<Goods> list = null;
        String sql = "select t.*,u.nickName from goods t  join user u on t.shopId = u.uid where u.roleId =2 and t.goodsStatus='上架'";
        ResultSet rs=executeSQL(sql);
        boolean flag =true;
        while (rs.next()){
            if(flag){
                list=new ArrayList<>();
                flag=false;
            }
            Goods goods = new Goods();
            goods.setGoodsId(rs.getInt("goodsId"));
            goods.setGoodsName(rs.getString("goodsName"));
            goods.setPrice(rs.getDouble("price"));
            goods.setStoreNum(rs.getInt("storeNum"));
            goods.setShopId(rs.getInt("shopId"));
            goods.setGoodsDescription(rs.getString("goodsDescription"));
            goods.setShopName(rs.getString("nickName"));
            list.add(goods);
        }
        return list;
    }

    //商品id修改商品
    @Override
    public int updateGoods(Goods goods,int goosId) {
        String sql = "update goods set goodsName=?,price = ? ,storeNum=? ,goodsDescription=? where goodsId = ?";
        Object[] params = {goods.getGoodsName(),goods.getPrice(),goods.getStoreNum(),goods.getGoodsDescription(),goosId};
        return executeUpdate(sql,params);
    }
    //商家新增商品
    @Override
    public int addGoods(Goods goods) {
        String sql = "insert into goods(goodsName,price,storeNum,goodsStatus,shopId,goodsDescription) values(?,?,?,?,?,?)";
        Object[] params = {goods.getGoodsName(),goods.getPrice(),goods.getStoreNum(),goods.getGoodsStatus(),goods.getShopId(),goods.getGoodsDescription()};
        return executeUpdate(sql,params);
    }
    //商家删除商品
    @Override
    public int deletGoods(Goods goods) {
        return -1;
    }
    //根据商品id查寻商品返回一个商品对象
    @Override
    public Goods queryByGoodsId(int goodsId) throws SQLException {
        Goods goods = null;
        String sql = "select * from goods where goodsId = ?";
        ResultSet rs=executeSQL(sql,goodsId);
        if(rs.next()){
            goods = new Goods();
            goods.setGoodsId(rs.getInt(1));
            goods.setGoodsName(rs.getString(2));
            goods.setPrice(rs.getDouble(3));
            goods.setStoreNum(rs.getInt(4));
            goods.setGoodsStatus(rs.getString(5));
            goods.setShopId(rs.getInt(6));
            goods.setGoodsDescription(rs.getString(7));
        }
        return goods;
    }




}
