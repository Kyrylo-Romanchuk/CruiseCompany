package ua.training.controller.command;

import ua.training.controller.command.servletAction.ServletAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    ServletAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
