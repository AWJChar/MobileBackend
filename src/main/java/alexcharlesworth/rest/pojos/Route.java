/*Holds route details fetched from database*/
package alexcharlesworth.rest.pojos;

public class Route {

    private String name;
    private String user_email;
    private String waypoints;

    @Override
    public String toString(){
        return "route{" +
                "name='" + name + '\'' +
                ", email='" + user_email + '\'' +
                ", waypoints='" + waypoints + '\'' +
                '}';

    }
}
