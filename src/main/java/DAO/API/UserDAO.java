package DAO.API;

import Domain.User;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: penghaozhang
 * Date: 20/03/13
 * Time: 5:04 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {
    ArrayList<User> getAllUsers();

    User getUserByUsername(String username);

    void addUser(User user);
}
