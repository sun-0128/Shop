package _0604.dao.impl;

import _0604.dao.BaseDao;
import _0604.dao.GoodsCartDao;
import _0604.pojo.GoodsCart;

/**
 * @author sunyong
 * @date 2020/06/04
 * @description
 */
public class GoodsCartDaoImpl extends BaseDao implements GoodsCartDao {

    @Override
    public void addGoodsCart(GoodsCart goodsCart) {
            String sql = "insert into `goodsCart`(buyerId,goodsId,buyNum,totalPrice) values(?,?,?,?)";
            Object[] params = {goodsCart.getBuyerId(),goodsCart.getGoodsId(),
                    goodsCart.getBuyNum(),goodsCart.getTotalPrice()};
            executeUpdate(sql,params);
    }
}
