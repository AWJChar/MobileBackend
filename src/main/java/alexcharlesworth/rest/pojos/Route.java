package alexcharlesworth.rest.pojos;

public class Route {

    private String name;
    private String user_email;
    private String waypoints;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return user_email;
    }

    public void setEmail(String email) {
        this.user_email = email;
    }

    public String getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(String waypoints) {
        this.waypoints = waypoints;
    }

    @Override
    public String toString(){
        return "route{" +
                "name='" + name + '\'' +
                ", email='" + user_email + '\'' +
                ", waypoints='" + waypoints + '\'' +
                '}';

    }
}
