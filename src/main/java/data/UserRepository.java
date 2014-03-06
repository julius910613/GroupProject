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

    public boolean findUserByEmail(String email){
        boolean flag = false;

        if(ud.getUserInfo(email) == null)  flag = false;
        else flag = true;
        return flag;
    }

    public void RegisterNewUser(User user){
        ud.addUserInfo(user.getUserName(), user);
    }


}
