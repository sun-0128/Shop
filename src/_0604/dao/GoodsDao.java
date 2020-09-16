package _0604.dao;

import _0604.pojo.Goods;
import _0604.pojo.User;

import java.sql.SQLException;
import java.util.List;

//商品表数据操作接口
public interface GoodsDao {
    //买家查询商品(模糊查询)
    List<Goods> queryGoodsByName(String name) throws SQLException;
    //卖家查看商品
    List<Goods> queryAll(User user) throws SQLException;

    //根据商品id修改商品
    int updateGoods(Goods goods,int goodsId);
    //卖家新增商品
    int  addGoods(Goods goods);
    //卖家删除商品
    int deletGoods(Goods goods);
    //根据商品id查寻商品返回一个商品对象
    Goods queryByGoodsId(int goodsId) throws SQLException;
    //查询所有商品
    List<Goods> queryAll() throws SQLException;
    //罗
    List<Goods> queryAll1() throws SQLException;
}
