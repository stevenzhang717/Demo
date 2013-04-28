package Service.Authentication;

import DAO.API.UserDAO;
import Domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: penghaozhang
 * Date: 20/03/13
 * Time: 2:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class UserDetailService implements UserDetailsService {
    @Resource
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDAO.getUserByUsername(s);
    }
}
