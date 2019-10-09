package ua.training.controller.util;

import org.apache.log4j.Logger;
import ua.training.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

public class SessionUtility {
    private final static Logger logger = Logger.getLogger(SessionUtility.class);

    public static void setUserRole(HttpServletRequest request,
                                   User.Role role, User user) {
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("userName", user.getLogin());
        session.setAttribute("role", role);
        logger.info("Set User and Role : " + user.toString());
    }

    public static void setUserRole(HttpServletRequest request,
                                   User.Role role, User user, String login) {
        HttpSession session = request.getSession();
        session.setAttribute("userName", login);
        session.setAttribute("user", user);
        session.setAttribute("role", role);
        logger.info("Set User and Role  : " + login + " and " + role);
    }

    public static boolean checkUserIsLogged(HttpServletRequest request, String userName) {
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext().getAttribute("loggedUsers");
        logger.info("logged Users Size HashSet---> " + loggedUsers.size());
        if (loggedUsers.stream().anyMatch(userName::equals)) {
            logger.info("Logged Users : true");
            logger.info("logged Users Size HashSet---> " + loggedUsers.size());
            return true;
        }
        loggedUsers.add(userName);
        logger.info("logged Users added : " + userName);
        logger.info("logged Users Size HashSet---> " + loggedUsers.size());
        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        return false;
    }
}
