package ua.training.controller.command;

import ua.training.controller.Endpoint;
import ua.training.controller.command.servletAction.Forward;
import ua.training.controller.command.servletAction.ServletAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WelcomePageCommand implements Command {

    @Override
    public ServletAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Forward forward = new Forward(Endpoint.getInstance().getProperty(Endpoint.INDEX_FORM));
        return forward;
    }
}
