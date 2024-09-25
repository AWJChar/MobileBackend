package alexcharlesworth.rest;

import alexcharlesworth.rest.db.DbUtils;
import alexcharlesworth.rest.db.MobileAppDao;
import alexcharlesworth.rest.pojos.Route;
import alexcharlesworth.rest.pojos.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class MobileAppController {

	@GetMapping(value="/login")
	public User login(@RequestParam(value= "email", defaultValue= "noEmail") String email, @RequestParam(value = "password") String password )  {

		MobileAppDao mobileAppDao = new MobileAppDao();
		SqlSession sqlSession = null;
		User user = null;

		try {
			sqlSession = DbUtils.getSqlSessionFactory().openSession();
			user = mobileAppDao.getUser(sqlSession, email, password);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			sqlSession.close();
		}

		return user;
	}

	@PostMapping(value="/create_user")
	public void createUser (@RequestBody User user) {

		MobileAppDao mobileAppDao = new MobileAppDao();
		SqlSession sqlSession = null;

		try {
			sqlSession = DbUtils.getSqlSessionFactory().openSession();
			mobileAppDao.createUser(sqlSession,user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			sqlSession.close();
		}
	}

	@GetMapping(value="/routes")
	public Route loadRoute(@RequestParam(value= "routeName") String routeName) {

		MobileAppDao mobileAppDao = new MobileAppDao();
		SqlSession sqlSession = null;
		Route route = null;

		try {
			sqlSession = DbUtils.getSqlSessionFactory().openSession();
			route = mobileAppDao.getRoute(sqlSession, routeName);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			sqlSession.close();
		}
		return route;
	}
}
