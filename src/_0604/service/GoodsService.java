package _0604.service;

import _0604.pojo.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsService {
    List<Goods> queryAll() throws SQLException;
}
