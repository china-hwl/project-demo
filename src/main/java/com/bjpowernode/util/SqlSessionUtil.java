package com.bjpowernode.util;

import com.mysql.cj.Session;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public SqlSessionUtil() {
    }

    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    //取得session对象
    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();
    public static SqlSession getSession(){
        SqlSession session = t.get();
        if(session==null){
            session = sqlSessionFactory.openSession();
            t.set(session);
        }
        return session;
    }
    //关闭session对象
    public static void closeSession(SqlSession session){
        if (session!=null){
            session.close();
            t.remove();
        }
    }
}
