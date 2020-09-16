package _0604.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author sunyong
 * @date 2020/05/30
 * @description
 * 读取数据库的属性文件,获取信息
 */
public class ConfigMgr {
    //如何让用户只能创建一个该类的对象?
    /*
     *-->单例模式
     * 1)私有构造方法
     * 2)程序提供给别人唯一对象(私有一个静态该类对象,写一个静态方法获取唯一对象)
     */
    private static ConfigMgr configMgr;
    private  Properties p;
    private ConfigMgr(){
        String configFile = "1.properties";
        //getClassLoader文件需要放在src目录(类的同级目录下)下面且不能带/否则会报错
       InputStream is =ConfigMgr.class.getClassLoader().getResourceAsStream(configFile);
        //class.getResourceAsStream文件需要放在src目录(类的同级目录下)且必须带/
//        InputStream is =ConfigMgr.class.getResourceAsStream(configFile);
       p = new Properties();
       try {
            p.load(is);
//            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //提供给别人一个唯一的对象
    public static ConfigMgr getInstance(){
        if(configMgr==null){
            configMgr=new ConfigMgr();
        }
        return configMgr;
    }
    //根据属性文件中的键获取值
    public String getString(String key){
       return p.getProperty(key);
    }
}
