package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {
    private Object target;

    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }

    //代理类的业务方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        SqlSession session = null;
        try{
            session = SqlSessionUtil.getSession();
            //代理处理业务逻辑
            obj = method.invoke(target,args);
            //处理业务完毕后，提交事务
            session.commit();
        } catch (Exception e){
            session.rollback();
        }finally {
            SqlSessionUtil.closeSession(session);
        }
        return obj;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }
}
