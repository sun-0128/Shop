package _0604.dao.impl;

import _0604.dao.BaseDao;
import _0604.dao.GoodsCartDao;
import _0604.dao.UserDao;
import _0604.pojo.User;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunyong
 * @date 2020/06/04
 * @description
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    //1)通过反射获取Logger对象
    Logger logger = Logger.getLogger(UserDaoImpl.class);
    //向用户表插入用户(注册时用到)
    @Override
    public void insert(User user) {
        getConnection();
        String sql = "insert into user(uname,nickname,password,roleid,phone,address,IDcard) values(?,?,?,?,?,?,?) ";
        Object[] params = {user.getUname(),user.getNickName(),user.getPassword(),user.getRoleId(),user.getPhone(),user.getAddress(),user.getIDcard()};
        executeUpdate(sql,params);
        close();
    }
    //根据名字获取用户返回一个结果集
    @Override
    public ResultSet getUserByName(String name) {
        String sql = "select uname from user where uname = ? ";
        ResultSet rs= executeSQL(sql,name);
//        close();
        return rs;
    }
    //根据名字获取用户,返回一个用户对象
    @Override
    public User queryUserByName(String name) throws SQLException {
        String sql = "select * from user where uname = ? ";
        ResultSet rs = executeSQL(sql,name);
        User user = null;
        while (rs.next()){
            user=new User();
            user.setUname(rs.getString("uname"));
            user.setPassword(rs.getString("password"));
            user.setRoleId(rs.getInt("roleId"));
            user.setPhone(rs.getString("phone"));
            user.setAddress(rs.getString("address"));
            user.setIDcard(rs.getString("IDcard"));
            user.setNickName(rs.getString("nickname"));
        }
//        close();
        return user;
    }
    //根据密码和名字获取用户(应该只有一个)
    @Override
    public User queryUserByNameAndPwd(String name, String pwd) throws SQLException {
        String sql = "select * from user where uname = ? and password = ? ";
        Object[] params = {name,pwd};
        ResultSet rs = executeSQL(sql,params);
        User user = null;
        if(rs.next()){
            user=new User();
            user.setUid(rs.getInt("uid"));
            user.setUname(rs.getString("uname"));
            user.setPassword(rs.getString("password"));
            user.setRoleId(rs.getInt("roleId"));
            user.setPhone(rs.getString("phone"));
            user.setAddress(rs.getString("address"));
            user.setIDcard(rs.getString("IDcard"));
            user.setNickName(rs.getString("nickname"));
            user.setLoginStatus(rs.getInt("loginStatus"));
        }
        return user;
    }
    //修改用户信息
    @Override
    public int updateUser(User user) {
        String sql = "update `user` set phone=? ,address=? ,nickname=? where uname=? and roleid!=0 ";
        Object[] params = {user.getPhone(),user.getAddress(),user.getNickName(),user.getUname()};
        return executeUpdate(sql,params);
    }

    //更新登陆状态
    @Override
    public int updateLoginStatus(User user) {
        int a = user.getLoginStatus();
        String sql = "update `user` set loginStatus = ? where uname = ?";
        Object[] params = {user.getLoginStatus(),user.getUname()};
        int num = executeUpdate(sql,params);
        logger.info("执行update成功");
        logger.debug("测试");
//        System.out.println(num>0?"登录成功":"登陆失败");
        logger.debug(num>0?"登录成功":"登陆失败");
        return  num;
    }
    //获取所有除管理员外的用户
    @Override
    public List<User> getAllUser() throws SQLException {
        List<User> list = new LinkedList<>();
        String sql = "select * from user where roleid!=0";
        ResultSet rs=executeSQL(sql);
        while (rs.next()){
            User user = new User();
            user.setUid(rs.getInt("uid"));
            user.setUname(rs.getString("uname"));
            user.setPassword(rs.getString("password"));
            user.setRoleId(rs.getInt("roleId"));
            user.setPhone(rs.getString("phone"));
            user.setAddress(rs.getString("address"));
            user.setIDcard(rs.getString("IDcard"));
            user.setNickName(rs.getString("nickname"));
            user.setLoginStatus(rs.getInt("loginStatus"));
            list.add(user);
        }
        return list;
    }

    public static void main(String[] args) {
        UserDaoImpl dao = new UserDaoImpl();
    }
}
