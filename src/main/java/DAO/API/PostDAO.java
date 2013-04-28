package DAO.API;

import Domain.Post;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: penghaozhang
 * Date: 17/04/13
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PostDAO {
    public ArrayList<Post> getPostsByUsername(String username);

    void addPost(Post post);
}
