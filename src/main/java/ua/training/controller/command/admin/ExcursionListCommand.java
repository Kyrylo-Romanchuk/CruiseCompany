package ua.training.controller.command.admin;

import ua.training.controller.Endpoint;
import ua.training.controller.command.Command;
import ua.training.controller.command.servletAction.Forward;
import ua.training.controller.command.servletAction.ServletAction;
import ua.training.controller.service.ExcursionService;
import ua.training.model.Excursion;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ExcursionListCommand implements Command {
    private ExcursionService excursionService;

    public ExcursionListCommand() {
        this.excursionService = new ExcursionService();
    }

    @Override
    public ServletAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Excursion> excursions = excursionService.showListExcursion();
        session.setAttribute("excursions", excursions);
        return new Forward(Endpoint.getInstance().getProperty(Endpoint.EXCURSION_LIST_FORM));
    }
}
