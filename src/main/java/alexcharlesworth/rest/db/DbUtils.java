/*Connects backend to relational database*/
package alexcharlesworth.rest.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class DbUtils {

    private static SqlSessionFactory sqlSessionFactory;

    //facilitates sending SQL requests to the database using info from mybatis-config.xml
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {

        if (sqlSessionFactory == null) {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        return sqlSessionFactory;
    }
}

