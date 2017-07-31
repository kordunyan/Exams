package com.exams.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private SqlSessionFactory sqlSessionFactory;

    private static final String PROD_CONFIG_NAME = "mybatis-config.xml";
    private static final String TEST_CONFIG_NAME = "test-mybatis-config.xml";

    public MyBatisUtil(String type) {
        try {
            InputStream inputStream = null;
            switch (type){
                case "prod":
                    inputStream = Resources.getResourceAsStream(PROD_CONFIG_NAME);
                    break;
                default:
                    inputStream = Resources.getResourceAsStream(TEST_CONFIG_NAME);
            }
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public  SqlSessionFactory getSqlSessnioFactory() {
        return sqlSessionFactory;
    }
}
