package alexandercharlesworth.rest.db;

import alexcharlesworth.rest.db.DbUtils;
import alexcharlesworth.rest.db.MobileAppDao;
import alexcharlesworth.rest.pojos.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class MobileAppDaoTest {

    private static MobileAppDao mobileAppDao;
    private static SqlSession sqlSession;

    @BeforeAll
    public static void init() throws Exception{
        mobileAppDao = new MobileAppDao();
        sqlSession = DbUtils.getSqlSessionFactory().openSession();
    }

    @AfterAll
    public static void tearDown(){
        sqlSession.close();
    }

    @Test
    public void getUserFound() throws IOException {
            User user = mobileAppDao.getUser(sqlSession, "joe@gmail.net", "Password1");
            Assertions.assertNotNull(user);
            System.out.println(user);
    }

    @Test
    public void getUserBadEmail() throws IOException {
            User user = mobileAppDao.getUser(sqlSession, "non_user@gmail.net", "Password1");
            Assertions.assertNull(user);
    }

    @Test
    public void getUserBadPassword() throws IOException {
            User user = mobileAppDao.getUser(sqlSession, "joer@gmail.net", "BadPassword");
            Assertions.assertNull(user);
    }

    @Test
    public void getNullUser() throws IOException {
        User user = mobileAppDao.getUser(sqlSession, null, "BadPassword");
        Assertions.assertNull(user);
    }

    @Test
    public void getNullPassword() throws IOException {
        User user = mobileAppDao.getUser(sqlSession, null, "BadPassword");
        Assertions.assertNull(user);
    }
}