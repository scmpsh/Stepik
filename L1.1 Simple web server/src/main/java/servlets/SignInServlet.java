package servlets;

import dbService.dao.UserDAO;
import dbService.dataSets.UserDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SignInServlet extends HttpServlet {
    private final UserDAO userDAO;

    public SignInServlet(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //get logged user profile
//    public void doGet(HttpServletRequest request,
//                      HttpServletResponse response) throws ServletException, IOException {
//        String sessionId = request.getSession().getId();
//        UserProfile profile = accountService.getUserBySessionId(sessionId);
//        response.setContentType("text/html;charset=utf-8");
//        if (profile == null) {
//            response.getWriter().println("401 UNAUTHORIZED");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        } else {
////            Gson gson = new Gson();
////            String json = gson.toJson(profile);
//            response.getWriter().println("You are in");
//            response.setStatus(HttpServletResponse.SC_OK);
//        }
//    }

    //sign in
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (login == null || pass == null || login.equals("") || pass.equals("")) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        try {
            long id = userDAO.getUserId(login);
            UserDataSet user = userDAO.getWithId(id);
            if (id != 0 && login.equals(user.getLogin()) && pass.equals(user.getPassword())) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("Authorized: " + user.getLogin());
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("Unauthorized");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (SQLException e) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Unauthorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            e.printStackTrace();
        }

//        if (login == null || pass == null) {
//            response.setContentType("text/html;charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            return;
//        }
//
//        UserProfile profile = accountService.getUserByLogin(login);
//        if (profile == null) {
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().println("ERROR: Invalid login");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
//        }
//        if (profile.getLogin().equals(login) && !profile.getPass().equals(pass)) {
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().println("ERROR: Invalid password");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
//        }
//
//        accountService.addSession(request.getSession().getId(), profile);
////        Gson gson = new Gson();
////        String json = gson.toJson(profile);
//        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().println("OK: You authorized");
//        response.setStatus(HttpServletResponse.SC_OK);
    }

//    //sign out
//    public void doDelete(HttpServletRequest request,
//                         HttpServletResponse response) throws ServletException, IOException {
//
//        try {
//            UsersDAO usersDAO = new UsersDAO(Main.dbService.getConnection());
//            usersDAO.deleteUser(Main.accountService.getUserByLogin(request.getParameter("login")));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if (profile == null) {
//            response.setContentType("text/html;charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        } else {
//            accountService.deleteSession(sessionId);
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().println("OK: Goodbye!");
//            response.setStatus(HttpServletResponse.SC_OK);
//        }
//    }
}
