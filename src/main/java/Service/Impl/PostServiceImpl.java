package Service.Impl;

import DAO.API.PostDAO;
import Domain.Post;
import Service.API.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: penghaozhang
 * Date: 18/04/13
 * Time: 1:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@Service("postService")
public class PostServiceImpl implements PostService {
    @Resource
    private PostDAO postDAO;

    @Override
    public ArrayList<Post> getPostByUsername(String username) {
        return postDAO.getPostsByUsername(username);
    }

    @Override
    public void addPost(Post post) {
        postDAO.addPost(post);
    }


}
