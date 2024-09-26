/*Controls the requests received from frontend and maps to their relevant functions*/
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

	//Maps login requests to the login SQL statement
	@GetMapping(value="/login")
	public User login(@RequestParam(value= "email", defaultValue= "noEmail") String email, @RequestParam(value = "password") String password )  {

		//Establishes connection to DB
		MobileAppDao mobileAppDao = new MobileAppDao();
		SqlSession sqlSession = null;
		User user = null;

		//Checks for requested user details and assigns to User obj if possible
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
		//Returns User obj to frontend
		return user;
	}

	//Maps createUser requests to the DB
	@PostMapping(value="/create_user")
	public User createUser (@RequestBody User user) {

		//Establishes connection to DB
		MobileAppDao mobileAppDao = new MobileAppDao();
		SqlSession sqlSession = null;

		//Attempts to add new user to database (email is primary key)
		try {
			sqlSession = DbUtils.getSqlSessionFactory().openSession();
			return mobileAppDao.createUser(sqlSession,user);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			sqlSession.close();
		}
	}

	//Maps route requests to DB
	@GetMapping(value="/routes")
	public Route loadRoute(@RequestParam(value= "routeName") String routeName) {

		//Establishes connection to DB
		MobileAppDao mobileAppDao = new MobileAppDao();
		SqlSession sqlSession = null;
		Route route = null;

		//Searches DB for route with routeName name and returns to frontend
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
