package _0604.dao;

import _0604.pojo.Order;
import _0604.pojo.User;

import java.sql.SQLException;
import java.util.List;

//订单表数据操作接口
public interface OrderDao {
    //添加订单
    void addOrder(Order order);
    List<Order> queryByUser(User user) throws SQLException;
}
