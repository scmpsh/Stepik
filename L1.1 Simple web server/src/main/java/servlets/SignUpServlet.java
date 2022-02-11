package servlets;

import dbService.dao.UserDAO;
import dbService.dataSets.UserDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SignUpServlet extends HttpServlet {
    private final UserDAO userDAO;

    public SignUpServlet(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //sign up
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            if (login != null && password != null
                    && !login.equals("") && !password.equals("")) {
                UserDataSet userDataSet = userDAO.getWithLogin(login);
                if (userDataSet != null && !login.equals(userDataSet.getLogin())) {
                    long id = userDAO.insertUser(login, password);
                    System.out.println("Added user with id: " + id + " | login: " + login +
                            " | password: " + password);
                    response.setContentType("text/html;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_OK);
                    return;
                } else if (userDataSet == null) {
                    long id = userDAO.insertUser(login, password);
                    System.out.println("Added user with id: " + id + " | login: " + login +
                            " | password: " + password);
                    response.setContentType("text/html;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_OK);
                    return;
                }
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Bad request");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//        if (login != null && password != null && !login.equals("") && !password.equals("")) {
//            if (accountService.getUserByLogin(login) != null
//                    && accountService.getUserByLogin(login).getLogin().equals(login)) {
//                response.setContentType("text/html;charset=utf-8");
//                response.getWriter().println("OK: Account with this username already exists");
//                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            } else {
//                accountService.addNewUser(new UserProfile(login, password));
//                response.setContentType("text/html;charset=utf-8");
//                response.getWriter().println("OK: You have successfully registered");
//                response.setStatus(HttpServletResponse.SC_OK);
//            }
//        } else {
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().println("ERROR: Enter some symbols in login and password");
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//        }
    }
