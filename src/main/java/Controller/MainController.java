package Controller;

import Domain.Post;
import Domain.User;
import Service.API.PostService;
import Service.API.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: penghaozhang
 * Date: 8/03/13
 * Time: 5:17 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MainController {
    private static String DEFAULT_POSTS_ORDER = "created";
    @Resource
    private UserService userService;
    @Resource
    private PostService postService;

    @RequestMapping("/")
    public ModelAndView main() {
        return new ModelAndView("home");
    }

    @RequestMapping("/login")
    public ModelAndView showLogin() {
        return new ModelAndView("login");
    }

    @RequestMapping("/register")
    public ModelAndView login() {
        return new ModelAndView("register");
    }

    @RequestMapping("/addUser")
    public ModelAndView addUser(@RequestParam String username, @RequestParam String password,
                                @RequestParam String email, HttpServletRequest request) {
        //add the user and get the user object
        User user = userService.addUser(username, password, email);

        //setting to request attribute for authorization purpose
        request.setAttribute("user", user);
        return new ModelAndView("registration_success");
    }

    @RequestMapping("/isUsernameUnique")
    public
    @ResponseBody
    boolean isUsernameUnique(@RequestParam String username) {
        //check whether here is a user with the same user name in the
        //database already and return the boolean result
        if (userService.getUserByUsername(username) != null) {
            return false;
        }
        return true;
    }

    @RequestMapping("/RedirectUser")
    public String redirectUser(Principal principal, HttpServletResponse response) {
        return "redirect:/users/" + principal.getName();
    }

    @RequestMapping("/users/{username}")
    public ModelAndView showFeeds(@PathVariable("username") String username, Principal principal, Model model) {
        if (principal != null && principal.getName().equals(username)) {
            model.addAttribute("showNewForm", true);
        }
        return new ModelAndView("posts");
    }

    @RequestMapping("/users/{username}/loadUserFeeds")
    public
    @ResponseBody
    ArrayList<Post> loadUserFeeds(@PathVariable("username") String username,
                                  @RequestParam(value = "order", required = false) String order) {
        if (order == null) {
            return postService.getPostByUsername(username, DEFAULT_POSTS_ORDER);
        } else {
            System.out.println(order);
            return postService.getPostByUsername(username, order);
        }
    }

    @RequestMapping(value = "/users/{username}/addPost", method = RequestMethod.POST)
    public String addPost(@PathVariable("username") String username, Principal principal,
                          @RequestParam String subject, @RequestParam String content,
                          @RequestParam String weather, HttpServletResponse response) throws IOException {
        //check wether the username is the current logged in user
        if (username.equals(principal.getName())) {
            User user = (User) ((Authentication) principal).getPrincipal();
            postService.addPost(new Post(user, subject, content, weather));
        }
        return "redirect:/users/" + principal.getName();

    }

}
