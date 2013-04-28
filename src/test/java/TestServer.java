import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * Created with IntelliJ IDEA.
 * User: penghaozhang
 * Date: 8/03/13
 * Time: 5:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        WebAppContext context = new WebAppContext();
        context.setDescriptor("/WEB-INF/web.xml");
        context.setResourceBase("src/main/web");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);

        server.setHandler(context);
        server.start();
        server.join();
    }
}
