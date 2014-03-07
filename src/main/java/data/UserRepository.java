package data;

import dataset.UserData;

import model.User;


/**
 * Created with IntelliJ IDEA.
 * User: cmdadmin
 * Date: 06/03/14
 * Time: 09:03
 * To change this template use Document | Settings | Document Templates.
 */
public class UserRepository {

   static UserData ud = new UserData();

    public User findUserByEmail(String email){

        return ud.getUserInfo(email);
    }

    public void RegisterNewUser(User user){
        ud.addUserInfo(user.getUserName(), user);
    }


}
