package ua.training.controller.command.admin;

import ua.training.controller.Endpoint;
import ua.training.controller.command.Command;
import ua.training.controller.command.servletAction.Forward;
import ua.training.controller.command.servletAction.ServletAction;
import ua.training.controller.service.ShipService;
import ua.training.model.Ship;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShipListCommand implements Command {

    private ShipService shipService;

    public ShipListCommand() {
        this.shipService = new ShipService();
    }

    @Override
    public ServletAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Ship> ships = shipService.showListShips();
        session.setAttribute("ships", ships);
        return new Forward(Endpoint.getInstance().getProperty(Endpoint.SHIP_LIST_FORM));
    }
}

