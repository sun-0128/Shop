package _0604.servlet;

import _0604.dao.impl.UserDaoImpl;
import _0604.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
 * @author sunyong
 * @date 2020/06/05
 * @description
 * 用户注销
*/


@WebServlet(name = "uzs",urlPatterns = "/uzs")
public class UserZhuxiaoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session =req.getSession();
        Object o=session.getAttribute("user");
        User user= (User) o;
        user.setLoginStatus(0);
        UserDaoImpl dao = new UserDaoImpl();
        dao.updateLoginStatus(user);
//        session.invalidate();
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
