package DAO.Impl;

import DAO.API.PostDAO;
import Domain.Post;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: penghaozhang
 * Date: 17/04/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("postDAO")
public class PostDAOImpl implements PostDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public ArrayList<Post> getPostsByUsername(String username) {
        //get the post list and order it by date
        ArrayList<Post> posts = (ArrayList<Post>) hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Post.class)
                .add(Property.forName("user.username").eq(username)).addOrder(Property.forName("created").desc()));
        return posts;
    }

    @Override
    public void addPost(Post post) {
        hibernateTemplate.saveOrUpdate(post);
    }
}
