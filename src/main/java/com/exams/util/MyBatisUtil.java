package com.exams.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    private static final String PROD_CONFIG_NAME = "mybatis-config.xml";
    private static final String TEST_CONFIG_NAME = "test-mybatis-config.xml";

    static{
        try{
            InputStream inputStream = Resources.getResourceAsStream(PROD_CONFIG_NAME);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessnioFactory(){
        return sqlSessionFactory;
    }
}
