/*Controls the requests received from frontend and maps to their relevant functions*/
package alexcharlesworth.rest;

import alexcharlesworth.rest.db.DbUtils;
import alexcharlesworth.rest.db.MobileAppDao;
import alexcharlesworth.rest.pojos.Route;
import alexcharlesworth.rest.pojos.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

@RestController
public class MobileAppController {

	//Maps login requests to the login SQL statement
	@GetMapping(value="/login")
	public User login(@RequestParam(value= "email", defaultValue= "noEmail") String email, @RequestParam(value = "password") String password ) throws Exception {

		//Establishes connection to DB
		MobileAppDao mobileAppDao = new MobileAppDao();
		SqlSession sqlSession = DbUtils.getSqlSessionFactory().openSession();
		User user = null;

		//Checks for requested user details and assigns to User obj if possible
		try {
			user = mobileAppDao.getUser(sqlSession, email, password);
		}
		finally {
			sqlSession.close();
		}
		//Returns User obj to frontend
		return user;
	}

	//Maps createUser requests to the DB
	@PostMapping(value="/create_user")
	public void createUser (@RequestBody User user) throws Exception {

		//Establishes connection to DB
		MobileAppDao mobileAppDao = new MobileAppDao();
		SqlSession sqlSession = DbUtils.getSqlSessionFactory().openSession();

		//Attempts to add new user to database (email is primary key)
		try {
			mobileAppDao.createUser(sqlSession,user);
		}
		finally {
			sqlSession.close();
		}
	}

	//Maps route requests to DB
	@GetMapping(value="/routes")
	public Route loadRoute(@RequestParam(value= "routeName") String routeName) throws Exception {

		//Establishes connection to DB
		MobileAppDao mobileAppDao = new MobileAppDao();
		SqlSession sqlSession = DbUtils.getSqlSessionFactory().openSession();
		Route route = null;

		//Searches DB for route with routeName name and returns to frontend
		try {
			route = mobileAppDao.getRoute(sqlSession, routeName);
		} finally {
			sqlSession.close();
		}
		return route;
	}
}
