package Service.API;

import Domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: penghaozhang
 * Date: 23/03/13
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    public User addUser(String username, String password, String email);

    public String encryptPassword(String password);

    public User getUserByUsername(String username);
}
