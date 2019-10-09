package ua.training.controller.command.admin;

import ua.training.controller.command.Command;
import ua.training.controller.command.servletAction.Redirect;
import ua.training.controller.command.servletAction.ServletAction;
import ua.training.controller.service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountryUpdateCommand implements Command {
    private CountryService countryService;

    public CountryUpdateCommand() {
        this.countryService = new CountryService();
    }

    @Override
    public ServletAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        countryService.updateCountry(request);
        return new Redirect("//country");
    }
}
