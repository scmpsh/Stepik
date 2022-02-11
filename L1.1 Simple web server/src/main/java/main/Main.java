package main;

import dbService.DBException;
import dbService.DBServiceHibernate;
import dbService.DBServiceJDBC;
import dbService.dao.UserDAO;
import dbService.dao.UserDAOHibernate;
import dbService.dao.UserDAOJDBC;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.SessionImpl;
import org.hibernate.procedure.ProcedureCall;
import servlets.SignInServlet;
import servlets.SignUpServlet;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;

public class Main {

    public static void main(String[] args) throws Exception {
//        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();
//        accountService = new AccountService(dbService.getConnection());

//        DBServiceJDBC dbServiceJDBC = new DBServiceJDBC();
//        dbServiceJDBC.printConnectInfo();
//        UserDAO userDAOJDBC = new UserDAOJDBC(dbServiceJDBC.getConnection());
//        userDAOJDBC.dropTable();
//        userDAOJDBC.createTable();
//
//        CallableStatement callableStatement = dbServiceJDBC
//                .getConnection()
//                .prepareCall("call helloworld()");
//        callableStatement.execute();
//
        DBServiceHibernate dbServiceHibernate = new DBServiceHibernate();
        dbServiceHibernate.printConnectInfo();
        UserDAO userDAOHibernate = dbServiceHibernate.getUserDAO();

        ((SessionImpl)dbServiceHibernate.getSession()).connection()
                .prepareCall("call helloworld()")
                .execute();



        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.addServlet(new ServletHolder(allRequestsServlet), "/*");
//        context.addServlet(new ServletHolder(new SignUpServlet(userDAOJDBC)), "/signup");
//        context.addServlet(new ServletHolder(new SignInServlet(userDAOJDBC)), "/signin");
//        context.addServlet(new ServletHolder(new SignUpServlet(userDAOHibernate)), "/signup");
//        context.addServlet(new ServletHolder(new SignInServlet(userDAOHibernate)), "/signin");

//        ResourceHandler resource_handler = new ResourceHandler();
//        resource_handler.setResourceBase("/Users/migalnikita/Documents/JavaMentoring/JavaWeb/stepic_java_webserver/L1.1 Simple web server/public_html");
//
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{/*resource_handler, */context});

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}
