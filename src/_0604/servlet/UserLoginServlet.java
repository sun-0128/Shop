package _0604.servlet;

import _0604.pojo.User;
import _0604.service.UserService;
import _0604.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;




@WebServlet(name = "uls",urlPatterns = "/uls")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        HttpSession session =req.getSession();
        UserService service = new UserServiceImpl();
        User user=service.login(name,pwd);
        if(user==null){
            //查询失败不能登录
            req.getSession().setAttribute("msg","用户名或密码不正确");
            resp.sendRedirect("login.jsp");
        }else if (user.getLoginStatus()==1){
            //已在其他地方登录
            req.getSession().setAttribute("msg","用户已在其他地方登录,再次点击\"登录\"将会下线其他的设备,在本页面重新登陆");
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("uzs.jsp").forward(req,resp);
        }else {
            req.getSession().setAttribute("msg","登陆成功");
            service.changeLoginStatus();
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("loginSuccess.jsp").forward(req,resp);
        }
    }
}
