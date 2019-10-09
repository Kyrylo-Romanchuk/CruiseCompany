package ua.training.controller.command.user;

import org.apache.log4j.Logger;
import ua.training.controller.command.Command;
import ua.training.controller.command.servletAction.Forward;
import ua.training.controller.command.servletAction.Redirect;
import ua.training.controller.command.servletAction.ServletAction;
import ua.training.controller.service.UserService;
import ua.training.controller.util.SessionUtility;
import ua.training.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignInCommand implements Command {
    private final static Logger logger = Logger.getLogger(UserService.class);
    private UserService userService;

    public SignInCommand() {
        this.userService = new UserService();
    }

    @Override
    public ServletAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = userService.signIn(request);
        if (user != null) {
            if (SessionUtility.checkUserIsLogged(request, user.getLogin())) {
                return new Forward("/error");
            }
            SessionUtility.setUserRole(request, user.getRole(), user);
            return new Redirect("/");
        } else {
            session.setAttribute("message", "Error email or password");
            return new Redirect("//login");
        }
    }
}
