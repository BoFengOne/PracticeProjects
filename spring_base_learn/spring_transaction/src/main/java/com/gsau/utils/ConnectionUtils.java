package com.gsau.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;

 /**
  * @ Description:   连接的工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
  * @ Date: 2019/12/30 14:19
  * @ Author: wgq
  * @ Version: 1.0
  */
@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;
     /**
      * @ Description:  获取当前线程上的连接
      * @ Date: 2019/12/30 14:19
      * @ Author: wgq
      * @ Version: 1.0
      */
    public Connection getThreadConnection() {
        try{
            //1.先从ThreadLocal上获取
            Connection conn = tl.get();
            //2.判断当前线程上是否有连接
            if (conn == null) {
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            //4.返回当前线程上的连接
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
     /**
      * @ Description:把连接和线程解绑
      * @ Date: 2019/12/30 14:20
      * @ Author: wgq
      * @ Version: 1.0
      */
    public void removeConnection(){
        tl.remove();
    }
}
