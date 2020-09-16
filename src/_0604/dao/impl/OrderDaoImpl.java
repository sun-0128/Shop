package _0604.dao.impl;

import _0604.dao.BaseDao;
import _0604.dao.GoodsCartDao;
import _0604.dao.OrderDao;
import _0604.pojo.Order;
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
public class OrderDaoImpl extends BaseDao implements OrderDao {
    //添加订单
    @Override
    public void addOrder(Order order) {
        String sql = "insert into `order`(buyerId,goodsId,buyNum,totalPrice,orderType) values(?,?,?,?,?)";
        Object[] params = {order.getBuyerId(),order.getGoodsId(),order.getBuyNum(),order.getTotalPrice(),order.getOrderType()};
        executeUpdate(sql,params);
    }

    @Override
    public List<Order> queryByUser(User user) throws SQLException {
        List<Order> list = null;
        String sql = "select * from `order` where buyerId = ?";
        ResultSet rs=executeSQL(sql,user.getUid());
        boolean f = true;
        while (rs.next()){
            if(f){
                list=new ArrayList<>();
                f=false;
            }
            Order order =new Order();
            order.setOrderId(rs.getInt(1));
            order.setBuyerId(rs.getInt(2));
            order.setGoodsId(rs.getInt(3));
            order.setBuyNum(rs.getInt(4));
            order.setTotalPrice(rs.getDouble(5));
            order.setOrderType(rs.getString(6));
            list.add(order);
        }
        return list;
    }

    public static void main(String[] args) throws SQLException {
        User user = new User();
        user.setUid(2);
        OrderDaoImpl dao = new OrderDaoImpl();
        dao.queryByUser(user);
    }
}
