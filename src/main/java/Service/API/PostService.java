package Service.API;

import Domain.Post;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: penghaozhang
 * Date: 18/04/13
 * Time: 1:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PostService {
    public ArrayList<Post> getPostByUsername(String username);

    void addPost(Post post);
}
