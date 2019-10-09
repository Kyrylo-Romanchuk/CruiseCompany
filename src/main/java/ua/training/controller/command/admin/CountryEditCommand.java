package ua.training.controller.command.admin;

import ua.training.controller.Endpoint;
import ua.training.controller.command.Command;
import ua.training.controller.command.servletAction.Forward;
import ua.training.controller.command.servletAction.ServletAction;
import ua.training.controller.service.CountryService;
import ua.training.model.Country;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountryEditCommand implements Command {
    private CountryService countryService;

    public CountryEditCommand() {
        this.countryService = new CountryService();
    }

    @Override
    public ServletAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Country country = countryService.findById(id);
        request.setAttribute("country", country);
        return new Forward(Endpoint.getInstance().getProperty(Endpoint.COUNTRY_FORM));
    }
}
