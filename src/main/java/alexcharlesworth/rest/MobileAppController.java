package alexcharlesworth.rest;

import alexcharlesworth.rest.db.DbUtils;
import alexcharlesworth.rest.db.MobileAppDao;
import alexcharlesworth.rest.pojos.LoginForm;
import alexcharlesworth.rest.pojos.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MobileAppController {

	@PostMapping(value="/login")
	public User login(@RequestBody LoginForm loginForm) throws Exception {

		MobileAppDao mobileAppDao = new MobileAppDao();
		SqlSession sqlSession = DbUtils.getSqlSessionFactory().openSession();
		User user = null;

		try {
			user = mobileAppDao.getUser(sqlSession, loginForm.email(), loginForm.password());
		}
		finally {
			sqlSession.close();
		}

		return user;
	}
}
