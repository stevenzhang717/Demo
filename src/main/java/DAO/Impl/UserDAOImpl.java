package DAO.Impl;

import DAO.API.UserDAO;
import Domain.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: penghaozhang
 * Date: 20/03/13
 * Time: 5:04 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) hibernateTemplate.loadAll(User.class);
    }

    @Override
    public User getUserByUsername(String username) {
        ArrayList<User> users = (ArrayList<User>) hibernateTemplate.findByCriteria(DetachedCriteria.forClass(User.class)
                .add(Property.forName("username").eq(username)));
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public void addUser(User user) {
        hibernateTemplate.saveOrUpdate(user);
    }

}
