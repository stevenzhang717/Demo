package Service.Impl;

import DAO.API.UserDAO;
import Domain.Authority;
import Domain.User;
import Service.API.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: penghaozhang
 * Date: 23/03/13
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    private static boolean DEFAULT_ENABLED = true;
    private static boolean DEFAULT_NON_LOCKED = true;
    private static Authority DEFAULT_ROLE = Authority.ROLE_USER;

    @Resource
    private UserDAO userDAO;

    @Override
    public User addUser(String username, String password, String email) {
        User user = new User(username, encryptPassword(password), email, DEFAULT_ROLE);
        user.setEnabled(DEFAULT_ENABLED);
        user.setLocked(DEFAULT_NON_LOCKED);
        userDAO.addUser(user);
        return userDAO.getUserByUsername(username);
    }

    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    public String encryptPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digestedBytes = messageDigest.digest(password.getBytes());
            StringBuffer hexString = new StringBuffer();

            //convert the string to hexstring
            for (int i = 0; i < digestedBytes.length; i++) {
                if ((0xff & digestedBytes[i]) < 0x10) {
                    hexString.append("0"
                            + Integer.toHexString((0xFF & digestedBytes[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & digestedBytes[i]));
                }
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
