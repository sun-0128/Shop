package _0604.dao;

import _0604.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //插入用户(使用用户对象封装数据)
    void insert(User user);
    //根据名字查用户,返回一个结果集
    ResultSet getUserByName(String name);
    //根据名字查用户,返回一个用户对象
    User queryUserByName(String name) throws SQLException;
    //修改登录状态
    int updateLoginStatus(User user);
    //查看除管理员外的所有用户
    List<User> getAllUser() throws SQLException;
    //根据名字密码查用户,返回一个用户对象
    User queryUserByNameAndPwd(String name, String pwd) throws SQLException;
    //根据用户对象修改信息
    int updateUser(User user);
}
