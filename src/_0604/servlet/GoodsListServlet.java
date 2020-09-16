package _0604.servlet;

import _0604.dao.impl.GoodsDaoImpl;
import _0604.pojo.Goods;
import _0604.service.GoodsService;
import _0604.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;




@WebServlet(name = "goosList_S",urlPatterns = "/goosList_S")
public class GoodsListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        GoodsServiceImpl service = new GoodsServiceImpl();
        try {
            List<Goods> goodsList1 = service.queryAll();
            if(goodsList1==null || goodsList1.size()==0){
                req.getSession().setAttribute("msg","商品列表为空或未知错误");
                resp.sendRedirect("err.jsp");
            }else {
                req.getSession().setAttribute("goodsList1",goodsList1);
                resp.sendRedirect("goodsList_Testcfor.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
