package _0604.servlet;

import _0604.dao.impl.GoodsDaoImpl;
import _0604.pojo.Goods;
import _0604.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;



@WebServlet(name = "updateGS",urlPatterns = "/updateGS")
public class UpdateGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        int goodsId= Integer.valueOf((String)session.getAttribute("goodsId")) ;
        GoodsDaoImpl dao = new GoodsDaoImpl();
        try {
            Goods goods=dao.queryByGoodsId(goodsId);
            String goodsName = req.getParameter("goodsName");
            double price = Double.valueOf(req.getParameter("price"));
            int storeNum = Integer.valueOf(req.getParameter("storeNum"));
            String goodsDesc = req.getParameter("goodsDescription");
            goods.setGoodsName(goodsName);
            goods.setPrice(price);
            goods.setStoreNum(storeNum);
            goods.setGoodsDescription(goodsDesc);
            dao.updateGoods(goods,goodsId);
            resp.sendRedirect("addSuccess.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
