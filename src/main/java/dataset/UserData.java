package dataset;

import model.User;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: cmdadmin
 * Date: 06/03/14
 * Time: 09:33
 * To change this template use Document | Settings | Document Templates.
 */
public class UserData {

    public UserData(){
        User u1 = new User();
        u1.setUserEmailAddress("1");
        u1.setUserName("aa");
        userMap.put(u1.getUserEmailAddress(), u1);
        User u2 = new User();
        u2.setUserEmailAddress("2");
        u2.setUserName("bb");
        userMap.put(u2.getUserEmailAddress(), u2);
        User u3 = new User();
        u1.setUserEmailAddress("1");
        u1.setUserName("aa");
        userMap.put(u1.getUserEmailAddress(), u1);
    }

    private HashMap<String, User> userMap = new HashMap<String, User>();

    public User getUserInfo(String email) {
        User user = userMap.get(email);
        return user;
    }

    public void addUserInfo(String email, User user) {
        userMap.put(email, user);
    }

    public void removeUserInfo(String email) {
        userMap.remove(email);
    }


}
