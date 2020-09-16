package _0604.service.impl;

import _0604.dao.impl.GoodsDaoImpl;
import _0604.pojo.Goods;
import _0604.service.GoodsService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author sunyong
 * @date 2020/06/07
 * @description
 */
public class GoodsServiceImpl implements GoodsService {
    @Override
    public List<Goods> queryAll() throws SQLException {
        GoodsDaoImpl dao = new GoodsDaoImpl();
        return dao.queryAll1();
    }
}
