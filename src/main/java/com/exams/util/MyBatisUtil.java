package com.exams.util;

import com.exams.dao.factory.DatabaseType;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private SqlSessionFactory sqlSessionFactory;

    private static final String PROD_CONFIG_NAME = "mybatis-config.xml";
    private static final String TEST_CONFIG_NAME = "test-mybatis-config.xml";

    public MyBatisUtil(DatabaseType dataBaseType) {
        try {
            InputStream inputStream = null;
            switch (dataBaseType){
                case PRODUCTION:
                    inputStream = Resources.getResourceAsStream(PROD_CONFIG_NAME);
                    break;
                case TEST:
                    inputStream = Resources.getResourceAsStream(TEST_CONFIG_NAME);
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
