package _0604.dao;

import _0604.pojo.User;
import _0604.util.ConfigMgr;
import _0604.util.Prop;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.*;

/**
 * @author sunyong
 * @date 2020/05/30
 * @description
 * 数据库操作基类
 */
public class BaseDao {
    public Connection connection = null;
    public PreparedStatement pstmt=null;
    public ResultSet rs = null;
    //获取连接
    public boolean getConnection(){
        //加载不同数据库厂商提供的驱动jar包
        try {
//            Class.forName(ConfigMgr.getInstance().getString("driver"));
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = ConfigMgr.getInstance().getString("url");
//            String username = ConfigMgr.getInstance().getString("user");
//            String password= ConfigMgr.getInstance().getString("pwd");
            Class.forName(Prop.DRIVER);
            connection= DriverManager.getConnection(Prop.URL,Prop.USER,Prop.PWD);
//                connection=DriverManager.getConnection("jdbc:mysql://192.168.56.101:3306/Shop","kb07","ok");
            System.out.println("连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //增删改//参数不固定(数组思想)-->两种表现形式1)数组声明Object[] params 2)Object ...params
    public int executeUpdate(String sql,Object ...params){
        int updateRows=0;
        if(getConnection()){
            try {
                pstmt=connection.prepareStatement(sql);
                //填充占位符
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject((i+1),params[i]);
                }
                updateRows=pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return -1;
            }
        }else {
            return -1;
        }
        System.out.println("更新完成");
        return updateRows;
    }
    //查
    public ResultSet executeSQL(String sql,Object ...params){
        if(getConnection()){
            try {
                pstmt=connection.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject((i+1),params[i]);
                }
                rs=pstmt.executeQuery();
                System.out.println("查询完成");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
    //释放资源(先开的后关)
    public boolean close(){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        System.out.println("关闭完成");
        return true;
    }
}
