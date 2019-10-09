package ua.training.controller.command.user;

import ua.training.controller.Endpoint;
import ua.training.controller.command.Command;
import ua.training.controller.command.servletAction.Forward;
import ua.training.controller.command.servletAction.ServletAction;
import ua.training.controller.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PayCommand implements Command {
    private OrderService orderService;

    public PayCommand() {
        this.orderService = new OrderService();
    }

    @Override
    public ServletAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("userName");
        int excursionId = 0;
        String excursion = request.getParameter("excursion_id");
        int cartId = Integer.parseInt(request.getParameter("cart_id"));
        int cruiseId = Integer.parseInt(request.getParameter("cruise_id"));
        if (excursion != null) {
            excursionId = Integer.parseInt(excursion);
        }
        String result = orderService.makeOrder(login, cruiseId, cartId, excursionId);
        if (result != null) {
            session.setAttribute("msg", result);
        } else {
            session.setAttribute("msg", "Something Wrong!!!");
        }
        return new Forward(Endpoint.getInstance().getProperty(Endpoint.SUCCES_FORM));
    }
}
