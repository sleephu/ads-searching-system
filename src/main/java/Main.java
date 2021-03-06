
/* tomcat
import java.io.File;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
*/
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by sleephu2 on 7/21/16.
 */
public class Main {

    public static void main(String[] args) throws Exception {
 //       /* jetty
        String webDirLocation = "src/main/webapp/";
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.length() == 0) {
            webPort = "8080";
        }
        Server server = new Server(Integer.valueOf(webPort));
        WebAppContext root = new WebAppContext();
        root.setContextPath("/");
        root.setDescriptor(webDirLocation+"/WEB-INF/web.xml");
        root.setResourceBase(webDirLocation);
        root.setParentLoaderPriority(true);

        server.setHandler(root);
        server.start();
        server.join();
 //       */

        /* tomcat
        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.length() == 0) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.valueOf(webPort));

        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());
      //  ctx.setDefaultWebXml(webappDirLocation+"WEB-INF/web.xml");

        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
        */
    }
}
