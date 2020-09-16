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
*/


@WebServlet(name = "uus",urlPatterns = "/uus")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user= (User) session.getAttribute("user");
        String nick=req.getParameter("nickName");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        user.setNickName(nick);
        user.setPhone(phone);
        user.setAddress(address);
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.updateUser(user);
        resp.sendRedirect("userSend");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
