package _0604.servlet;

import _0604.dao.impl.GoodsDaoImpl;
import _0604.dao.impl.OrderDaoImpl;
import _0604.pojo.Goods;
import _0604.pojo.Order;
import _0604.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;



@WebServlet(name = "goumaiGS",urlPatterns = "/goumaiGS")
public class GoumaiGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String s= (String) session.getAttribute("goodsId");
        int goodsId = Integer.valueOf(s);
        User user = (User) session.getAttribute("user");
        int buyNum = Integer.valueOf(req.getParameter("buyNum"));
        GoodsDaoImpl dao = new GoodsDaoImpl();
        OrderDaoImpl orderDao = new OrderDaoImpl();

        try {
            Goods goods=dao.queryByGoodsId(goodsId);
            Order order = new Order();
            order.setBuyerId(user.getUid());
            order.setBuyNum(buyNum);
            order.setGoodsId(goodsId);
            order.setOrderType("已付款");
            order.setTotalPrice(goods.getPrice()*buyNum);
            orderDao.addOrder(order);
            //购买需要修改库存
//            String sql ="update goods set sotreNum = storeNum-? where goodsId = ?";
//            Object[] params = {buyNum,goodsId};
//            dao.executeUpdate(sql,params);
            //修改库存
            goods.setStoreNum(goods.getStoreNum()-buyNum);
            dao.updateGoods(goods,goodsId);
            resp.sendRedirect("maijiaIndex.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
