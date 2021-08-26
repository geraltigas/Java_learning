package com.geraltigas;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory
public class MybatisTest {

    private static SqlSessionFactory factory;
    static{
        String resource = "mybatis-config.xml";
        try {
            InputStream input = Resources.getResourceAsStream(resource);
             factory = new SqlSessionFactoryBuilder().build(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // 静态代码块只在类在加载时执行一次

    public static SqlSession getSqlSession(){
        return factory.openSession();
    }
}
