package ua.training.controller.listener;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

public class SessionListener implements HttpSessionListener {
    private final static Logger logger = Logger.getLogger(SessionListener.class);
 @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
     logger.info("Session Destroyed begin");
        HashSet<String> loggedUsers = (HashSet<String>) httpSessionEvent
                .getSession().getServletContext()
                .getAttribute("loggedUsers");
        logger.info("logged Users(Size): "+loggedUsers.size());
        String userName = (String) httpSessionEvent.getSession()
                .getAttribute("userName");
        loggedUsers.remove(userName);
        logger.info("logged Users removed (Size): "+loggedUsers.size());
        httpSessionEvent.getSession().setAttribute("loggedUsers", loggedUsers);
        logger.info("Session Destroyed end");
    }
}
