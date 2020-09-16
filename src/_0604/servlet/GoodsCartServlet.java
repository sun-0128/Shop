package _0604.servlet;

import _0604.dao.impl.GoodsCartDaoImpl;
import _0604.dao.impl.GoodsDaoImpl;
import _0604.dao.impl.OrderDaoImpl;
import _0604.pojo.Goods;
import _0604.pojo.GoodsCart;
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




@WebServlet(name = "goodsCartS",urlPatterns = "/goodsCartS")
public class GoodsCartServlet extends HttpServlet {
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
        GoodsCartDaoImpl cartDao = new GoodsCartDaoImpl();
        try {
            Goods goods=dao.queryByGoodsId(goodsId);
            GoodsCart goodsCart = new GoodsCart();
            goodsCart.setBuyerId(user.getUid());
            goodsCart.setBuyNum(buyNum);
            goodsCart.setGoodsId(goodsId);
            goodsCart.setTotalPrice(goods.getPrice()*buyNum);
            cartDao.addGoodsCart(goodsCart);
            resp.sendRedirect("maijiaIndex.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
