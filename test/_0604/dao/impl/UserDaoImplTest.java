package _0604.dao.impl;

import _0604.pojo.User;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    @Test
    public void insert() {

    }

    @Test
    public void getUserByName() {
    }

    @Test
    public void queryUserByName() {
    }

    @Test
    public void queryUserByNameAndPwd() throws SQLException {
        UserDaoImpl dao = new UserDaoImpl();
        User user=dao.queryUserByNameAndPwd("买家1","123456");
        System.out.println(user.getUname()+
        "\t"+user.getPassword());
    }

    @Test
    public void updateLoginStatus() {
    }
}