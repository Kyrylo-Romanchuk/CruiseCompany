package ua.training.controller.command.admin;

import ua.training.controller.Endpoint;
import ua.training.controller.command.Command;
import ua.training.controller.command.servletAction.Forward;
import ua.training.controller.command.servletAction.ServletAction;
import ua.training.controller.service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CountryShowListCommand implements Command {

    private CountryService countryService;

    public CountryShowListCommand() {
        this.countryService = new CountryService();
    }

    @Override
    public ServletAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List countries = countryService.showListContry();
        session.setAttribute("countries", countries);
        return new Forward(Endpoint.getInstance().getProperty(Endpoint.COUNTRY_LIST_FORM));
    }
}

