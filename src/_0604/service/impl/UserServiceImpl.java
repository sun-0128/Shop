package _0604.service.impl;

import _0604.dao.UserDao;
import _0604.dao.impl.UserDaoImpl;
import _0604.pojo.User;
import _0604.service.UserService;

import java.sql.SQLException;

/**
 * @author sunyong
 * @date 2020/06/05
 * @description
 */
public class UserServiceImpl implements UserService {
    public User user=null;
    //根据用户密码登录
    @Override
    public User login(String name, String pwd) {
        //1)对参数判空
        if(name==null || pwd==null || name.trim().equals("") || pwd.trim().equals("")){

        }else {
            //2)执行登陆查询
            UserDao dao = new UserDaoImpl();
            try {
                 user=dao.queryUserByNameAndPwd(name,pwd);
                //3)对查询结果进行操作
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //4)参数的其他合法性校验(黑白名单处理)
        return user;
    }
    //改变登陆状态
    @Override
    public void changeLoginStatus() {
        UserDao dao = new UserDaoImpl();
        user.setLoginStatus(1);
        dao.updateLoginStatus(user);
    }
}
