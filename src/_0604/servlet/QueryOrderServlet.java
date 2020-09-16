package _0604.servlet;

import _0604.dao.impl.OrderDaoImpl;
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
import java.util.List;



@WebServlet(name = "queryOrderS",urlPatterns = "/queryOrderS")
public class QueryOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        OrderDaoImpl dao =new OrderDaoImpl();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        try {
            List<Order> orderList = dao.queryByUser(user);
            if(orderList!=null){
                session.setAttribute("orderList",orderList);
                resp.sendRedirect("order.jsp");
            }else {
                resp.sendRedirect("err.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
