package _0604.servlet;

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
 * 根据用户角色跳转到不同操作页面
*/


@WebServlet(name = "userSend",urlPatterns = "/userSend")
public class UserSend extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Object o=session.getAttribute("user");
        User user= (User) o;
        if(user.getRoleId()==1){
            //买家首页
            resp.sendRedirect("maijiaIndex.jsp");
        }else if (user.getRoleId()==2){
            //商家首页
            resp.sendRedirect("shangjiaIndex.jsp");
        }else {
            //超级管理员
            resp.sendRedirect("SuperMgr.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
