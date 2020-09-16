package _0604.service;

import _0604.pojo.User;
//用户的业务逻辑判断接口
public interface UserService {
    //根据密码名称登录
    User login(String name, String pwd);
    //改变登陆状态
    void changeLoginStatus();
}
