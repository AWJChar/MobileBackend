package alexcharlesworth.rest;

import alexcharlesworth.rest.db.DbUtils;
import alexcharlesworth.rest.db.MobileAppDao;
import alexcharlesworth.rest.pojos.Route;
import alexcharlesworth.rest.pojos.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

@RestController
public class MobileAppController {

	@GetMapping(value="/login")
	public User login(@RequestParam(value= "email", defaultValue= "noEmail") String email, @RequestParam(value = "password") String password ) throws Exception {

		MobileAppDao mobileAppDao = new MobileAppDao();
		SqlSession sqlSession = DbUtils.getSqlSessionFactory().openSession();
		User user = null;

		try {
			user = mobileAppDao.getUser(sqlSession, email, password);
		}
		finally {
			sqlSession.close();
		}

		return user;
	}

	@GetMapping(value="/routes")
	public Route loadRoute(@RequestParam(value= "routeName") String routeName) throws Exception {

		MobileAppDao mobileAppDao = new MobileAppDao();
		SqlSession sqlSession = DbUtils.getSqlSessionFactory().openSession();
		Route route = null;

		try {
			route = mobileAppDao.getRoute(sqlSession, routeName);
		} finally {
			sqlSession.close();
		}
		return route;
	}
}
