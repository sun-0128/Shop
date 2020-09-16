package _0604.servlet;

import _0604.dao.UserDao;
import _0604.dao.impl.UserDaoImpl;
import _0604.pojo.User;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;




@WebServlet(name = "ucs",urlPatterns ="/usc" )
public class UserCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session =req.getSession();
        String uname=req.getParameter("uname");
        String nickName = req.getParameter("nickName");
        String pwd = req.getParameter("pwd");
        String juese = req.getParameter("juese");
        int roleId = juese.equals("买家")?1:2;
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String IDcard = req.getParameter("IDcard");
        UserDaoImpl dao = new UserDaoImpl();
        ResultSet rs=dao.getUserByName(uname);
        try {
            if(!rs.next()|| rs==null){
               // 用户注册
                User user = new User();
                user.setUname(uname);
                user.setNickName(nickName);
                user.setPassword(pwd);
                user.setRoleId(roleId);
                user.setPhone(phone);
                user.setAddress(address);
                user.setIDcard(IDcard);
                dao.insert(user);
                resp.sendRedirect("createSuccess.jsp");
            }else {
                //用户已存在
                req.getRequestDispatcher("create.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
