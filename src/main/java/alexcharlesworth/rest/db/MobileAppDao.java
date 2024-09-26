/*Maps incoming SQL requests and performs Database operations*/
package alexcharlesworth.rest.db;

import alexcharlesworth.rest.pojos.Route;
import alexcharlesworth.rest.pojos.User;
import org.apache.ibatis.session.SqlSession;
import java.util.HashMap;
import java.util.Map;

public class MobileAppDao {

    //Takes email and password and returns relevant user details
    public User getUser(SqlSession session, String email, String password) {

        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);

        return session.selectOne("mobileApp.get_user", params);
    }

    //Inserts new user into the DB
    public void createUser(SqlSession session, User user) {
        session.insert("create_user", user);
        session.commit();
    }

    //Returns the route of specified name
    public Route getRoute(SqlSession session, String routeName) {

        return session.selectOne("mobileApp.get_route", routeName);
    }
}

