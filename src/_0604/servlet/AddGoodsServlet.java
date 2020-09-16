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



@WebServlet(name = "ags",urlPatterns = "/ags")
public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("user");
        int shopId = ((User)obj).getUid();
        String goodsName = req.getParameter("goodsName");
        double price = Double.valueOf(req.getParameter("price"));
        int storeNum = Integer.valueOf(req.getParameter("storeNum"));
        String goodsStatus = req.getParameter("goodsStatus");
        String goodsDesc = req.getParameter("goodsDescription");
        Goods goods = new Goods();
        goods.setShopId(shopId);
        goods.setGoodsDescription(goodsDesc);
        goods.setGoodsStatus(goodsStatus);
        goods.setStoreNum(storeNum);
        goods.setPrice(price);
        goods.setGoodsName(goodsName);
        GoodsDaoImpl dao = new GoodsDaoImpl();
        dao.addGoods(goods);
        resp.sendRedirect("addSuccess.jsp");
    }
}
