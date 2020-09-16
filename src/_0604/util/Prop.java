package _0604.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author sunyong
 * @date 2020/06/05
 * @description
 * 该类为工具类-->加载数据库配置文件
 */
public class Prop {
    //使用单例模式保证该对象只有一个
   static private Properties p;
    static {
        p=new Properties();
        InputStream is= Prop.class.getClassLoader().getResourceAsStream("1.properties");
        try {
            p.load(is);
            System.out.println("配置文件加载成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //工具类不需要构建对象
    private Prop() {
    }
    public static final String DRIVER=p.getProperty("driver");
    public static final String URL = p.getProperty("url");
    public static final String USER = p.getProperty("user");
    public static final String PWD = p.getProperty("pwd");

}
