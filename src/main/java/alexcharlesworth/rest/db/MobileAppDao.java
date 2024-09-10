package alexcharlesworth.rest.db;

import alexcharlesworth.rest.pojos.Route;
import alexcharlesworth.rest.pojos.User;
import org.apache.ibatis.session.SqlSession;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobileAppDao {
    public User getUser(SqlSession session, String email, String password) {

        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);

        return session.selectOne("mobileApp.get_user", params);
    }

    public Route getRoute(SqlSession session, String routeName) {

        return session.selectOne("mobileApp.get_route", routeName);
    }
}

